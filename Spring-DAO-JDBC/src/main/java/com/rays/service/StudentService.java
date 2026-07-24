package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.dao.StudentDAO;
import com.rays.dto.StudentDTO;

@Service
public class StudentService {

	@Autowired
	StudentDAO dao;

	public int add(StudentDTO dto) {

		return dao.add(dto);

	}

	public void update(StudentDTO dto) {

		dao.update(dto);

	}

	public void delete(int id) {
		dao.delete(id);
	}

	public StudentDTO findByLogin(String login) {
		return dao.findByLogin(login);
	}

	public StudentDTO findByPK(int pk) {
		return dao.findByPK(pk);
	}

	public StudentDTO authenticate(String login, String password) {
		StudentDTO user = dao.authenticate(login, password);
		return user;
	}

	public List search(StudentDTO dto) {
		return dao.search(dto);
	}

	public List search(StudentDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

}
