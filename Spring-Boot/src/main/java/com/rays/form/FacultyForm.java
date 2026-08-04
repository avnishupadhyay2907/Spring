package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.FacultyDTO;
import com.rays.dto.SubjectDTO;

public class FacultyForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;

	@NotEmpty(message = "Last Name is required")
	private String lastName;

	@NotEmpty(message = "Gender is required")
	private String gender;

	@NotEmpty(message = "Email Id is required")
	private String emailId;

	@NotEmpty(message = "Mobile No is required")
	private String mobileNo;

	@NotNull(message = "College is required")
	private Long collegeId;

	@NotNull(message = "Course is required")
	private Long courseId;

	@NotNull(message = "Subject is required")
	private Long subjectId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BaseDTO getDto() {
		FacultyDTO dto = (FacultyDTO) initDTO(new FacultyDTO());

		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setGender(gender);
		dto.setEmailId(emailId);
		dto.setMobileNo(mobileNo);
		dto.setCollegeId(collegeId);
		dto.setCourseId(courseId);
		dto.setSubjectId(subjectId);

		return dto;
	}

}
