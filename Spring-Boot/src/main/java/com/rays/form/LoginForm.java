package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.UserDTO;

public class LoginForm extends BaseForm {

	@NotEmpty(message = "Login Id is required")
	private String login;

	@NotEmpty(message = "Password is required")
	private String password;

	public String getPassword() {
		return password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BaseDTO getDto() {
		UserDTO dto = new UserDTO();
		dto.setLogin(login);
		dto.setPassword(password);
		return dto;
	}

}
