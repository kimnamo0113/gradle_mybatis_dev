package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.gradle_mybatis_dev.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student); //typehandler이용
	Student selectStudentByNoWithResultMap(Student student); //resultmap이용
	List<Student> selectStudentByAll();
	
	List<Map<String, Object>> selectStudentMapByAll();
	
	int insertStudent(Student student);
	int insertStudentAutoinc(Student student);
	int updateStudent(Student student);
	int deleteStudent(int i);
	void test();
}
