package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.dto.CourseDTO;
import com.rays.dto.UserDTO;

@Repository
public class CourseDAO {

	@PersistenceContext
	EntityManager entityManager;

	public long add(CourseDTO dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(CourseDTO dto) {

		entityManager.merge(dto); // merge method to insert or update

	}

	public void delete(long id) {

		CourseDTO dto = findByPk(id);

		entityManager.remove(dto); // remove method to delete

	}

	public CourseDTO findByPk(long id) {

		CourseDTO dto = entityManager.find(CourseDTO.class, id); // find method to find by id

		return dto;

	}

	public List<CourseDTO> search(CourseDTO dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<CourseDTO> criteriaQuery = builder.createQuery(CourseDTO.class);

		Root<CourseDTO> root = criteriaQuery.from(CourseDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {

			if (dto.getId() != null && dto.getId() > 0) {

				predicateList.add(builder.equal(root.get("id"), dto.getId()));

			}

			if (dto.getName() != null && dto.getName().length() > 0) {

				predicateList.add(builder.like(root.get("name"), dto.getName() + "%"));

			}

			if (dto.getDescription() != null && dto.getDescription().length() > 0) {

				predicateList.add(builder.like(root.get("description"), dto.getDescription() + "%"));

			}

			if (dto.getDuration() != null && dto.getDuration().length() > 0) {
				predicateList.add(builder.like(root.get("duration"), dto.getDuration() + "%"));
			}

		}
		criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));

		TypedQuery<CourseDTO> query = entityManager.createQuery(criteriaQuery);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List<CourseDTO> list = query.getResultList();
		return list;
	}

}
