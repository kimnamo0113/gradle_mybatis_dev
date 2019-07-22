package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.GregorianCalendar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_dev.AbstractTest;
import kr.or.yi.gradle_mybatis_dev.dto.Course;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseMapperTest extends AbstractTest{
	private static CourseMapper courseDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		courseDao=new CourseMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		courseDao=null;
	}

	@Test
	public void test01SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, Object> map=new HashMap<String, Object>();
		//조건이 하나도 만족하지 않을 경우
		List<Course> list = courseDao.selectCoursesbyCondition(map);
		
		//courseId=1
		map.put("courseId", 1);
		list = courseDao.selectCoursesbyCondition(map);
		
		//courseName="%java%"
		map.clear();
		map.put("courseName", "%java%");
		list = courseDao.selectCoursesbyCondition(map);
		
		GregorianCalendar cal = new GregorianCalendar(2013,1,1);
		map.put("startDate", cal.getTime());
		list = courseDao.selectCoursesbyCondition(map);
		
		Assert.assertNotNull(list);
	}
	@Test
	public void test02SelectCoursesbyChoosee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, Object> map=new HashMap<String, Object>();
		//조건이 하나도 만족하지 않을 경우
		List<Course> list = courseDao.selectCoursesbyCondition(map);
		
		//courseId=1
		map.put("searchBy", "Tutor");
		map.put("tutorId",1);
		list = courseDao.selectCoursesbyChoosee(map);
		
		//courseName="%java%"
		map.clear();
		map.put("searchBy", "CourseName");
		map.put("courseName", "%java%");
		list = courseDao.selectCoursesbyChoosee(map);
		
		Assert.assertNotNull(list);
	}
}
