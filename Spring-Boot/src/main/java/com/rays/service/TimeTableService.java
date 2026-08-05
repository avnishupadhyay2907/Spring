package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.TimeTableDAO;
import com.rays.dto.TimeTableDTO;

@Service
public class TimeTableService {

	@Autowired
	TimeTableDAO dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(TimeTableDTO dto) {

		if (dto.getId() != null && dto.getId() > 0) {
			dao.update(dto);
		} else {
			dao.add(dto);
		}

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	public TimeTableDTO findById(long id) {
		return dao.findByPk(id);
	}

	@Transactional(readOnly = true)
	public List<TimeTableDTO> search(TimeTableDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);

	}

}
