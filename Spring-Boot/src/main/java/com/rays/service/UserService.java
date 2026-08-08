package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.RoleDAO;
import com.rays.dao.UserDAO;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;
import com.rays.exception.DuplicateRecordException;

@Service
public class UserService {

	@Autowired
	UserDAO dao;

	@Autowired
	RoleDAO roleDao;

	@Transactional(readOnly = true)
	public UserDTO findByLogin(String login) {
		UserDTO dto = dao.findByUniqueKey("login", login);

		if (dto != null) {
			return dto;
		}

		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {

		System.out.println("dto = " + dto);
		System.out.println("roleId = " + dto.getRoleId());
		System.out.println("roleDao = " + roleDao);
		System.out.println("dao = " + dao);
		System.out.println("Incoming Login ===========> [" + dto.getLogin() + "]");
		RoleDTO roleDTO = roleDao.findByPk(dto.getRoleId());
		UserDTO existDto = findByLogin(dto.getLogin().trim());
		System.out.println("Exist DTO ===========> " + existDto);

		System.out.println("roleDTO = " + roleDTO);

		if (existDto != null && existDto.getLogin() != null) {

			throw new DuplicateRecordException("Login Id already exist");
		}

		if (roleDTO != null) {
			dto.setRoleName(roleDTO.getName());
		}
		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {

		UserDTO existDto = findByLogin(dto.getLogin());

		if (existDto != null && dto.getId() != existDto.getId()) {
			throw new DuplicateRecordException("loginId already exist");
		}
		dao.update(dto);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	public UserDTO findById(long id) {
		return dao.findByPk(id);
	}

	@Transactional(readOnly = true)
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);

	}

	@Transactional(readOnly = true)
	public UserDTO authenticate(String login, String password) {

		UserDTO dto = findByLogin(login);

		if (dto != null)
			if (dto.getPassword().equals(password))
				return dto;

		return null;
	}

}
