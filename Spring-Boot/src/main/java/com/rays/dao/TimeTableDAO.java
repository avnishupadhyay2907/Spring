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
import com.rays.dto.TimeTableDTO;

@Repository
public class TimeTableDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	CourseDAO courseDAO;

	@Autowired
	SubjectDAO subjectDAO;

	public TimeTableDTO populateDto(TimeTableDTO dto) {

		CourseDTO courseDto = courseDAO.findByPk(dto.getCourseId());
		SubjectDTO subjectDTO = subjectDAO.findByPk(dto.getSubjectId());

		if (courseDto != null) {
			dto.setCourseName(courseDto.getName());
		}
		if (subjectDTO != null) {
			dto.setSubjectName(subjectDTO.getSubjectName());
		}
		return dto;
	}

	public long add(TimeTableDTO dto) {

		populateDto(dto);
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(TimeTableDTO dto) {

		populateDto(dto);
		entityManager.merge(dto); // merge method to insert or update

	}

	public void delete(long id) {

		TimeTableDTO dto = findByPk(id);

		entityManager.remove(dto); // remove method to delete

	}

	public TimeTableDTO findByPk(long id) {

		TimeTableDTO dto = entityManager.find(TimeTableDTO.class, id); // find method to find by id

		return dto;

	}

	public List<TimeTableDTO> search(TimeTableDTO dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<TimeTableDTO> cq = builder.createQuery(TimeTableDTO.class);

		Root<TimeTableDTO> root = cq.from(TimeTableDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {
			if (dto.getId() != null && dto.getId() > 0) {
				predicateList.add(builder.equal(root.get("id"), dto.getId()));
			}
			if (dto.getSemester() != null && dto.getSemester().length() > 0) {
				predicateList.add(builder.like(root.get("semester"), dto.getSemester() + "%"));
			}

			if (dto.getDescription() != null && dto.getDescription().length() > 0) {
				predicateList.add(builder.like(root.get("description"), dto.getDescription() + "%"));
			}

			if (dto.getExamDate() != null && dto.getExamDate().length() > 0) {
				predicateList.add(builder.like(root.get("examDate"), dto.getExamDate() + "%"));
			}

			if (dto.getExamTime() != null && dto.getExamTime().length() > 0) {
				predicateList.add(builder.like(root.get("examTime"), dto.getExamTime() + "%"));
			}

			if (dto.getCourseId() != null && dto.getCourseId() > 0) {
				predicateList.add(builder.equal(root.get("courseId"), dto.getCourseId()));
			}

			if (dto.getCourseName() != null && dto.getCourseName().length() > 0) {
				predicateList.add(builder.like(root.get("courseName"), dto.getCourseName() + "%"));
			}

			if (dto.getSubjectId() != null && dto.getSubjectId() > 0) {
				predicateList.add(builder.equal(root.get("subjectId"), dto.getSubjectId()));
			}

			if (dto.getSubjectName() != null && dto.getSubjectName().length() > 0) {
				predicateList.add(builder.like(root.get("subjectName"), dto.getSubjectName() + "%"));
			}
		}
		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));

		TypedQuery<TimeTableDTO> query = entityManager.createQuery(cq);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List<TimeTableDTO> list = query.getResultList();

		return list;

	}

}
