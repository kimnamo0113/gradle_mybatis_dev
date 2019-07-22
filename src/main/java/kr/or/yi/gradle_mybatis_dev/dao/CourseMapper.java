package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.gradle_mybatis_dev.dto.Course;

public interface CourseMapper {
	List<Course> selectCoursesbyCondition(Map<String, Object> map);
	
	List<Course> selectCoursesbyChoosee(Map<String, Object> map);
}
