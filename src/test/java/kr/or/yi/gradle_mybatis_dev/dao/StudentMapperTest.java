package kr.or.yi.gradle_mybatis_dev.dao;

import static org.junit.Assert.*;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_dev.AbstractTest;
import kr.or.yi.gradle_mybatis_dev.dto.Gender;
import kr.or.yi.gradle_mybatis_dev.dto.PhoneNumber;
import kr.or.yi.gradle_mybatis_dev.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMapperTest extends AbstractTest {
	private static StudentMapper stdDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		stdDao=new StudentMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		stdDao=null;
	}

	@Test
	public void test01SelectStudentByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student std = new Student();
		std.setStudId(1);
		
		Student selectStd = stdDao.selectStudentByNo(std);
		log.debug(selectStd.toString());
		Assert.assertEquals(std.getStudId(), selectStd.getStudId());
	}
	@Test
	public void test02SelectStudentByNoWithResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student std = new Student();
		std.setStudId(1);
		
		Student selectStd = stdDao.selectStudentByNo(std);
		log.debug(selectStd.toString());
		Assert.assertEquals(std.getStudId(), selectStd.getStudId());
	}
	@Test
	public void test03SelectStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Student> lists = stdDao.selectStudentByAll();
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test04InsertStudent(){
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990,2,28);
		Student student=new Student();
		student.setStudId(3);
		student.setName("홍길동");
		student.setEmail("lee@test.co.kr");
		student.setPhone(new PhoneNumber("123-123-123"));
		student.setDob(newDate.getTime());
		int res=stdDao.insertStudent(student);
		List<Student> lists = stdDao.selectStudentByAll();
		Assert.assertEquals(1, res);
		Assert.assertNotNull(lists);
	}
	@Test
	public void test05InsertStudentAutoInc(){
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990,2,28);
		Student student=new Student();
		student.setName("홍길동4");
		student.setEmail("lee@test.co.kr");
		student.setPhone(new PhoneNumber("123-123-123"));
		student.setDob(newDate.getTime());
		
		int res=stdDao.insertStudentAutoinc(student);
		Assert.assertEquals(1, res);
		
		List<Student> lists = stdDao.selectStudentByAll();
		Assert.assertNotNull(lists);
	}
	@Test
	public void test06UpdateStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Student student = new Student();
		student.setStudId(4);
		student.setName("홍길동이");
		student.setEmail("lee@test.co.kr");
		student.setPhone(new PhoneNumber("123-123-123"));
		student.setDob(new Date());
		
		int result=stdDao.updateStudent(student);
		Assert.assertSame(1, result);
		student.setName("홍길동4");
		student.setEmail("lee@test.co.kr");
		student.setPhone(new PhoneNumber("123-123-123"));
		student.setDob(new GregorianCalendar(1988,04,25).getTime());
		result=stdDao.updateStudent(student);
		Assert.assertSame(1, result);
		
	}

	@Test
	public void test07DeleteStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		int deleteStudent=stdDao.deleteStudent(3);
		Assert.assertSame(1, deleteStudent);
	}
	
	@Test
	public void test00Test() {
		stdDao.test();
	}
	
	
	@Test
	public void test08selectStudentMapByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Map<String,Object>> list = stdDao.selectStudentMapByAll();
		Assert.assertNotNull(list);
		
		for(Map<String,Object> e : list) {
//			log.debug(e.toString());
			for(Entry<String, Object> ee : e.entrySet()) {
				log.debug(String.format("key(%s) -> value(%s)", ee.getKey(),ee.getValue()));
			}
			
		}
		
	}
	@Test
	public void test09selectStudentByNoResultMapExtends() {
	log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student std=new Student();
		std.setStudId(1);
		
		Student searchStudent=stdDao.selectStudentByNoResultMapExtends(std);
		Assert.assertNotNull(searchStudent);
		
		log.debug(searchStudent.toString());
	}
	
	@Test
	public void test10InsertStudentEnum(){
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990,2,28);
		Student student=new Student();
		student.setStudId(3);
		student.setName("홍길동");
		student.setEmail("lee@test.co.kr");
		student.setPhone(new PhoneNumber("123-123-123"));
		student.setDob(newDate.getTime());
		student.setGender(Gender.FEMAL);
		
		int res=stdDao.insertStudentEnum(student);
		Assert.assertEquals(1, res);
		
//		stdDao.deleteStudent(student.getStudId());
		Student selStd = stdDao.selectStudentByNo(student);
		log.debug(selStd+"");
	}
	
	@Test
	public void test11SelectStudentbyMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String,String> map = new HashMap<String, String>();
		map.put("name", "Timothy");
		map.put("email","timothy@gmail.com");
		
		Student std=stdDao.selectStudentByMap(map);
		log.debug(std.toString());
		
		map.remove("email");
		std=stdDao.selectStudentByMap(map);
		log.debug(std.toString());
		
		map.clear();
		map.put("email","timothy@gmail.com");
		std=stdDao.selectStudentByMap(map);
		log.debug(std.toString());
		
		Assert.assertNotNull(std);
	}
	
	
	@Test
	public void test12SelectStudentForMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<Integer, String> result = stdDao.selectStudentForMap();
		Assert.assertNotNull(result);
		
		for(Entry<Integer, String> e : result.entrySet()) {
			log.debug(String.format("%d -> %s",	e.getKey(),e.getValue()));
		}
	}
}








