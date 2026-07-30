package com.rays.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rays.dto.CollegeDTO;

@Repository
public class CollegeDAO {

	@PersistenceContext
	EntityManager entityManager;

	public long add(CollegeDTO dto) {

		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(CollegeDTO dto) {

		entityManager.merge(dto);
	}

	public CollegeDTO findByPk(long id) {

		CollegeDTO dto = entityManager.find(CollegeDTO.class, id);
		return dto;

	}

	public void delete(long id) {

		CollegeDTO dto = findByPk(id);

		entityManager.remove(dto);

	}

}
