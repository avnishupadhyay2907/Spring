package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_subject")
public class SubjectDTO extends BaseDTO {

	@Column(name = "SUBJECT_NAME", length = 50)
	private String subjectName;

	@Column(name = "DESCRIPTION", length = 50)
	private String description;

	@Column(name = "COURSE_ID")
	private Long courseId;

	@Column(name = "COURSE_NAME", length = 50)
	private String courseName;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

}
