package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_timeTable")
public class TimeTableDTO extends BaseDTO {

	@Column(name = "SEMESTER", length = 50)
	private String semester;

	@Column(name = "DESCRIPTION", length = 50)
	private String description;

	@Column(name = "EXAM_DATE", length = 50)
	private String examDate;

	@Column(name = "EXAM_TIME", length = 50)
	private String examTime;

	@Column(name = "COURSE_ID")
	private Long courseId;

	@Column(name = "COURSE_NAME", length = 50)
	private String courseName;

	@Column(name = "SUBJECT_ID")
	private Long subjectId;

	@Column(name = "SUBJECT_NAME", length = 50)
	private String subjectName;

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

}
