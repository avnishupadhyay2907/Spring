package com.rays.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAO {

	@PersistenceContext
	EntityManager entityManager;

	public long add(UserDTO dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(UserDTO dto) {

		entityManager.merge(dto); // merge method to insert or update

	}

	public void delete(long id) {

		UserDTO dto = findByPk(id);

		entityManager.remove(dto); // remove method to delete

	}

	public UserDTO findByPk(long id) {

		UserDTO dto = entityManager.find(UserDTO.class, id); // find method to find by id

		return dto;

	}

}
