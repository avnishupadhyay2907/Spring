package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.StudentDTO;

public class StudentForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;

	@NotEmpty(message = "Last Name is required")
	private String lastName;

	@NotEmpty(message = "Mobile No is required")
	private String mobileNo;

	@NotEmpty(message = "Email is required")
	private String email;

	@NotNull(message = "College is required")
	private Long collegeId;

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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	@Override
	public BaseDTO getDto() {
		StudentDTO dto = (StudentDTO) initDTO(new StudentDTO());

		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setMobileNo(mobileNo);
		dto.setEmail(email);
		dto.setCollegeId(collegeId);

		return dto;
	}

}
