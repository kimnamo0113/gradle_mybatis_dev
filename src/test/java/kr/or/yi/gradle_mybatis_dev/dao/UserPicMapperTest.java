package kr.or.yi.gradle_mybatis_dev.dao;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_dev.AbstractTest;
import kr.or.yi.gradle_mybatis_dev.dto.UserPic;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserPicMapperTest extends AbstractTest {
	private static UserPicMapper picDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		picDao = new UserPicMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		picDao = null;
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void test01InsertUserPic() throws IOException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		UserPic userPic = new UserPic();
		userPic.setId(1);
		userPic.setName("김태리");
		String bio = "김태리는 1990년 4월 24일 서울에서 태어났다. 김태리에서 '태'(泰)는 집안의 돌림자고 '리'(梨)는 배나무를 뜻한다. 태어날 때 동네에 배꽃이 만개한 것에서 따온 이름이다. 어머니는 정치를 하길 바라는 마음에서 '태정'을 원하셨지만 아버지가 출생신고 하러 가는 길에 '태리'로 바꾸셨다고 한다.[3] 막연히 아나운서가 되고 싶은 생각에 경희대학교 신문방송학과에 입학했다. 이때까지만 해도 연기, 연극, 영화에 대한 관심은 하나도 없었다. 김태리가 처음 연기를 접한 계기는 대학 연극 동아리. 1학년 때 신입단원을 모집하는 연극을 보고 연극 동아리에 가입했고, 2학년 때 진로를 연극배우로 결정했다고 한다.[4] 동아리 활동을 하며 독립 영화 《시민좀비》에 출연하기도 했으며, 대학을 졸업할 즈음엔 대학로로 나가 극단에 들어갔다.";
		userPic.setBio(bio);
		userPic.setPic(getPicFile());
		int result = picDao.insertUserPic(userPic);
		Assert.assertEquals(1, result);
	}

	private byte[] getPicFile() throws IOException {
		byte[] pic = null;
		File file = new File(System.getProperty("user.dir")+"\\images\\김태리.jpg");
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){
			pic=new byte[bis.available()];
			bis.read(pic);
			return pic;
		}
	}
	
	@Test
	public void test02SelectUserPic() throws FileNotFoundException, IOException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		UserPic userPic = new UserPic();
		userPic.setId(1);
		
		UserPic searchPic=picDao.selectUserPic(userPic);
		Assert.assertNotNull(searchPic);
		if(searchPic.getPic()!=null) {
			File file = getPicFile(searchPic);
			log.debug("file Path="+file.getAbsolutePath());
		}
	}

	private File getPicFile(UserPic userPic) throws IOException {
		File pics = new File(System.getProperty("user.dir")+"\\pics\\");
		if(!pics.exists()) {
			pics.mkdir();
		}
		File pic = new File(pics, userPic.getName()+".jpg");
		try(BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(pic))){
			bos.write(userPic.getPic());
		}
		return pic;
	}
	
	@Test
	public void test03DeleteUserPic() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		UserPic userPic = new UserPic();
		userPic.setId(1);
		
		int res=picDao.deleteUserPic(userPic);
		Assert.assertEquals(1, res);
		
		File pics = new File(System.getProperty("user.dir")+"\\pics\\");
		if(pics.exists()) {
			pics.delete();
		}
		pics.delete();
	}
}
