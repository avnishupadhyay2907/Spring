package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.TimeTableDTO;

public class TimeTableForm extends BaseForm {

	@NotEmpty(message = "Semester is required")
	private String semester;

	@NotEmpty(message = "Description is required")
	private String description;

	@NotEmpty(message = "Exam Date is required")
	private String examDate;

	@NotEmpty(message = "Exam Time is required")
	private String examTime;

	@NotNull(message = "Course is required")
	private Long courseId;

	@NotNull(message = "Subject is required")
	private Long subjectId;

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

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	@Override
	public BaseDTO getDto() {

		TimeTableDTO dto = (TimeTableDTO) initDTO(new TimeTableDTO());

		dto.setSemester(semester);
		dto.setDescription(description);
		dto.setExamDate(examDate);
		dto.setExamTime(examTime);
		dto.setCourseId(courseId);
		dto.setSubjectId(subjectId);

		return dto;
	}
}
