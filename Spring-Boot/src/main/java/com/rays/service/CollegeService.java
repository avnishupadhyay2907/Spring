package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.CollegeDAO;
import com.rays.dto.CollegeDTO;

@Service
public class CollegeService {

	@Autowired
	CollegeDAO dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(CollegeDTO dto) {
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

	public CollegeDTO findById(long id) {
		return dao.findByPk(id);
	}
}
