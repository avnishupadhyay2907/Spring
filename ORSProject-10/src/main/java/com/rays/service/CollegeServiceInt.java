package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.CollegeDTO;

public interface CollegeServiceInt extends BaseServiceInt<CollegeDTO> {

	public CollegeDTO findByName(String name, UserContext userContext);

}
