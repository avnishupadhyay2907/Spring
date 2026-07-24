package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.dao.UserDAO;
import com.rays.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	UserDAO dao;

	public int add(UserDTO dto) {

		return dao.add(dto);

	}

	public void update(UserDTO dto) {

		dao.update(dto);

	}

	public void delete(int id) {
		dao.delete(id);
	}

	public UserDTO findByLogin(String login) {
		return dao.findByLogin(login);
	}

	public UserDTO findByPK(int pk) {
		return dao.findByPK(pk);
	}

	public UserDTO authenticate(String login, String password) {
		UserDTO user = dao.authenticate(login, password);
		return user;
	}

	public List search(UserDTO dto) {
		return dao.search(dto);
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

}
