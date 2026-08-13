package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.CollegeDAOInt;
import com.rays.dto.CollegeDTO;

@Service
@Transactional
public class CollegeServiceImpl extends BaseServiceImpl<CollegeDTO, CollegeDAOInt> implements CollegeServiceInt {

	@Transactional(readOnly = true)
	public CollegeDTO findByName(String name, UserContext userContext) {
		return baseDao.findByUniqueKey(name, name, userContext);
	}

}
