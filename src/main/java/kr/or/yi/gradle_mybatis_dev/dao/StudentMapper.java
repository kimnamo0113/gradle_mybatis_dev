package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.List;
import java.util.Map;

import kr.or.yi.gradle_mybatis_dev.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student); //typehandler이용
	Student selectStudentByNoWithResultMap(Student student); //resultmap이용
	List<Student> selectStudentByAll();
	
	Student selectStudentByNoResultMapExtends(Student student);
	List<Map<String, Object>> selectStudentMapByAll();
	
	//매개변수를 hashMap로 전달(여러개 입력파라미터전달방법)
	Student selectStudentByMap(Map<String, String> map);
	
	//ResultSet 처리방식의 재정의
	Map<Integer, String> selectStudentForMap();
	
	
	int insertStudent(Student student);
	int insertStudentAutoinc(Student student);
	int insertStudentEnum(Student student);
	
	int updateStudent(Student student);
	int deleteStudent(int i);
	void test();
}
