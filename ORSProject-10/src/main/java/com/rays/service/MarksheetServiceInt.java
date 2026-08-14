package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.MarksheetDTO;

public interface MarksheetServiceInt extends BaseServiceInt<MarksheetDTO> {

	public MarksheetDTO findByRoll(String rollNo, UserContext userContext);

}
