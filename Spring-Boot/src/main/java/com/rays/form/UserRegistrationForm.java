package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.UserDTO;

public class UserRegistrationForm extends BaseForm {

	@NotEmpty(message = "firstName is required")
	private String firstName;

	@NotEmpty(message = "lastName is required")
	private String lastName;

	@NotEmpty(message = "loginId is required")
	private String login;

	@NotEmpty(message = "password is required")
	private String password;

	public UserRegistrationForm() {
	}

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BaseDTO getDto() {
		UserDTO dto = new UserDTO();
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setLogin(login);
		dto.setPassword(password);

		dto.setRoleId(2L);
		return dto;
	}

}
