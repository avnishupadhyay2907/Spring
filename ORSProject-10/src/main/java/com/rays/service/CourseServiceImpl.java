package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.CourseDAOInt;
import com.rays.dto.CourseDTO;

@Service
@Transactional
public class CourseServiceImpl extends BaseServiceImpl<CourseDTO, CourseDAOInt> implements CourseServiceInt {

	@Transactional(readOnly = true)
	public CourseDTO findByName(String name, UserContext userContext) {
		return baseDao.findByUniqueKey(name, name, userContext);
	}

}