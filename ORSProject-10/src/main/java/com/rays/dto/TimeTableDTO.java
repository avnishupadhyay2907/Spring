package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_timetable")
public class TimeTableDTO extends BaseDTO {

	@Column(name = "semester", length = 45)
	private String semester;

	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "exam_date")
	private Date examDate;

	@Column(name = "exam_time", length = 45)
	private String examTime;

	@Column(name = "course_id")
	private Long courseId;

	@Column(name = "course_name", length = 255)
	private String courseName;

	@Column(name = "subject_id")
	private Long subjectId;

	@Column(name = "subject_name", length = 255)
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

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
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

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return courseName;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "semester";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return semester;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Semester";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Time Table";
	}

}
