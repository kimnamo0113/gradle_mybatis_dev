package kr.or.yi.gradle_mybatis_dev.dao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.yi.gradle_mybatis_dev.AbstractTest;
import kr.or.yi.gradle_mybatis_dev.dto.PhoneNumber;
import kr.or.yi.gradle_mybatis_dev.dto.Student;

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
	public void testSelectStudentByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student std = new Student();
		std.setStudId(1);
		
		Student selectStd = stdDao.selectStudentByNo(std);
		log.debug(selectStd.toString());
		Assert.assertEquals(std.getStudId(), selectStd.getStudId());
	}
	@Test
	public void testSelectStudentByNoWithResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student std = new Student();
		std.setStudId(1);
		
		Student selectStd = stdDao.selectStudentByNo(std);
		log.debug(selectStd.toString());
		Assert.assertEquals(std.getStudId(), selectStd.getStudId());
	}
	@Test
	public void testSelectStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Student> lists = stdDao.selectStudentByAll();
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void testInsertStudent(){
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
	public void testInsertStudentAutoInc(){
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
	public void testUpdateStudent() {
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
	public void testDeleteStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		int deleteStudent=stdDao.deleteStudent(3);
		Assert.assertSame(1, deleteStudent);
	}
}
