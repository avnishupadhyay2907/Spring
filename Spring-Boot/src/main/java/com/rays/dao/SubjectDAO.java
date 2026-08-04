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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;

@Repository
public class SubjectDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	CourseDAO courseDAO;

	public SubjectDTO populateDto(SubjectDTO dto) {

		CourseDTO courseDto = courseDAO.findByPk(dto.getCourseId());

		if (courseDto != null) {

			dto.setCourseName(courseDto.getName());

		}
		return dto;

	}

	public long add(SubjectDTO dto) {

		populateDto(dto);
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(SubjectDTO dto) {

		populateDto(dto);
		entityManager.merge(dto); // merge method to insert or update

	}

	public void delete(long id) {

		SubjectDTO dto = findByPk(id);

		entityManager.remove(dto); // remove method to delete

	}

	public SubjectDTO findByPk(long id) {

		SubjectDTO dto = entityManager.find(SubjectDTO.class, id); // find method to find by id

		return dto;

	}

	public List<SubjectDTO> search(SubjectDTO dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<SubjectDTO> cq = builder.createQuery(SubjectDTO.class);

		Root<SubjectDTO> root = cq.from(SubjectDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {
			if (dto.getId() != null && dto.getId() > 0) {
				predicateList.add(builder.equal(root.get("id"), dto.getId()));
			}
			if (dto.getSubjectName() != null && dto.getSubjectName().length() > 0) {
				predicateList.add(builder.like(root.get("subjectName"), dto.getSubjectName() + "%"));
			}
			if (dto.getDescription() != null && dto.getDescription().length() > 0) {
				predicateList.add(builder.like(root.get("description"), dto.getDescription() + "%"));
			}
			if (dto.getCourseId() != null && dto.getCourseId() > 0) {
				predicateList.add(builder.equal(root.get("courseId"), dto.getCourseId()));
			}
			if (dto.getCourseName() != null && dto.getCourseName().length() > 0) {
				predicateList.add(builder.like(root.get("courseName"), dto.getCourseName() + "%"));
			}
		}
		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));

		TypedQuery<SubjectDTO> query = entityManager.createQuery(cq);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List<SubjectDTO> list = query.getResultList();

		return list;

	}

}
