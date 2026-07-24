package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.dao.CollegeDAO;
import com.rays.dto.CollegeDTO;

@Service
public class CollegeService {

	@Autowired
	CollegeDAO dao;

	public int add(CollegeDTO dto) {

		return dao.add(dto);

	}

	public void update(CollegeDTO dto) {

		dao.update(dto);
	}

	public void delete(int id) {

		dao.delete(id);

	}

	public CollegeDTO findByName(String name) {

		return dao.findByName(name);

	}

	public CollegeDTO findByPk(int pk) {

		return dao.findByPK(pk);

	}

	public List search(CollegeDTO dto) {

		return dao.search(dto);

	}

	public List search(CollegeDTO dto, int pageNo, int pageSize) {

		return dao.search(dto, pageNo, pageSize);

	}

}
