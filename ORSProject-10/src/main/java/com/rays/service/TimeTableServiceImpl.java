package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.TimeTableDAOInt;
import com.rays.dto.TimeTableDTO;

@Service
@Transactional
public class TimeTableServiceImpl extends BaseServiceImpl<TimeTableDTO, TimeTableDAOInt>
		implements TimeTableServiceInt {

	@Transactional(readOnly = true)
	public TimeTableDTO findBySemester(String semester, UserContext userContext) {
		return baseDao.findByUniqueKey(semester, semester, userContext);
	}

}
