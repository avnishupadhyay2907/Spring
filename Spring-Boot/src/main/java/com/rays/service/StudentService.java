package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.StudentDAO;
import com.rays.dto.StudentDTO;

@Service
public class StudentService {

	@Autowired
	StudentDAO dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(StudentDTO dto) {

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
	public StudentDTO findById(long id) {
		return dao.findByPk(id);
	}

	@Transactional(readOnly = true)
	public List<StudentDTO> search(StudentDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);

	}

}
