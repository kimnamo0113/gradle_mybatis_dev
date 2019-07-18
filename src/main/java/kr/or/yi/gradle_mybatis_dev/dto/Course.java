package kr.or.yi.gradle_mybatis_dev.dto;

import java.util.Date;

public class Course {
	private int courseId;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private int tutoId;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getTutoId() {
		return tutoId;
	}

	public void setTutoId(int tutoId) {
		this.tutoId = tutoId;
	}

	@Override
	public String toString() {
		return String.format("Course [courseId=%s, name=%s, description=%s, startDate=%s, endDate=%s, tutoId=%s]",
				courseId, name, description, startDate, endDate, tutoId);
	}

}
