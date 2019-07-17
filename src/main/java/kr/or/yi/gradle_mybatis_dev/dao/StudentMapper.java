package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.List;

import kr.or.yi.gradle_mybatis_dev.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student); //typehandler이용
	Student selectStudentByNoWithResultMap(Student student); //resultmap이용
	List<Student> selectStudentByAll();
	int insertStudent(Student student);
	int insertStudentAutoinc(Student student);
	int updateStudent(Student student);
	int deleteStudent(int i);
}
