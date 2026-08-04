package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CourseDTO;

public class CourseForm extends BaseForm {

	@NotEmpty(message = "Name is required")
	private String name;

	@NotEmpty(message = "Description is required")
	private String description;

	@NotEmpty(message = "Duration is required")
	private String duration;

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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public BaseDTO getDto() {
		CourseDTO dto = (CourseDTO) initDTO(new CourseDTO());
		dto.setName(name);
		dto.setDescription(description);
		dto.setDuration(duration);

		return dto;
	}

}
