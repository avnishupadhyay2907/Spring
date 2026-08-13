package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.StudentDAOInt;
import com.rays.dto.StudentDTO;

@Service
@Transactional
public class StudentServiceImpl extends BaseServiceImpl<StudentDTO, StudentDAOInt> implements StudentServiceInt {

	@Transactional(readOnly = true)
	public StudentDTO findByEmail(String email, UserContext userContext) {
		return baseDao.findByUniqueKey(email, email, userContext);
	}

}
