package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_dev.dto.Course;
import kr.or.yi.gradle_mybatis_dev.jdbc.MyBatisSqlSessionFactory;

public class CourseMapperImpl implements CourseMapper {
	private String namespace="kr.or.yi.gradle_mybatis_dev.dao.CourseMapper";
	@Override
	public List<Course> selectCoursesbyCondition(Map<String, Object> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace+".selectCoursesbyCondition",map);
		}
	}
	@Override
	public List<Course> selectCoursesbyChoosee(Map<String, Object> map) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace+".selectCoursesbyChoosee",map);
		}
	}

}
