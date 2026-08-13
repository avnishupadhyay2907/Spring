package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.StudentDTO;

public interface StudentServiceInt extends BaseServiceInt<StudentDTO> {

	public StudentDTO findByEmail(String email, UserContext userContext);

}
