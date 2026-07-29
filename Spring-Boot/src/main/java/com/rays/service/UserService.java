package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.RoleDAO;
import com.rays.dao.UserDAO;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	UserDAO dao;

	@Autowired
	RoleDAO roleDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {

		System.out.println("dto = " + dto);
		System.out.println("roleId = " + dto.getRoleId());
		System.out.println("roleDao = " + roleDao);
		System.out.println("dao = " + dao);

		RoleDTO roleDTO = roleDao.findByPk(dto.getRoleId());

		System.out.println("roleDTO = " + roleDTO);

		if (roleDTO != null) {
			dto.setRoleName(roleDTO.getName());
		}

		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(UserDTO dto) {

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

	public UserDTO findById(long id) {
		return dao.findByPk(id);
	}

}
