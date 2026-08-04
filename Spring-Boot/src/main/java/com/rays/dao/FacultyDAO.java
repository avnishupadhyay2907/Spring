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

import com.rays.dto.CollegeDTO;
import com.rays.dto.CourseDTO;
import com.rays.dto.FacultyDTO;
import com.rays.dto.SubjectDTO;

@Repository
public class FacultyDAO {

	@PersistenceContext
	EntityManager entityManager;
	@Autowired
	CollegeDAO collegeDAO;
	@Autowired
	CourseDAO courseDAO;
	@Autowired
	SubjectDAO subjectDAO;

	public FacultyDTO populateDto(FacultyDTO dto) {

		CourseDTO courseDto = courseDAO.findByPk(dto.getCourseId());
		SubjectDTO subjectDTO = subjectDAO.findByPk(dto.getSubjectId());
		CollegeDTO collegeDTO = collegeDAO.findByPk(dto.getCollegeId());

		if (courseDto != null) {
			dto.setCourseName(courseDto.getName());
		}
		if (subjectDTO != null) {
			dto.setSubjectName(subjectDTO.getSubjectName());
		}
		if (collegeDTO != null) {
			dto.setCollegeName(collegeDTO.getName());
		}
		return dto;

	}

	public long add(FacultyDTO dto) {

		populateDto(dto);
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(FacultyDTO dto) {

		populateDto(dto);
		entityManager.merge(dto); // merge method to insert or update

	}

	public void delete(long id) {

		FacultyDTO dto = findByPk(id);

		entityManager.remove(dto); // remove method to delete

	}

	public FacultyDTO findByPk(long id) {

		FacultyDTO dto = entityManager.find(FacultyDTO.class, id); // find method to find by id

		return dto;

	}

	public List<FacultyDTO> search(FacultyDTO dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<FacultyDTO> cq = builder.createQuery(FacultyDTO.class);

		Root<FacultyDTO> root = cq.from(FacultyDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {
			if (dto.getId() != null && dto.getId() > 0) {
				predicateList.add(builder.equal(root.get("id"), dto.getId()));
			}

			if (dto.getFirstName() != null && !dto.getFirstName().isEmpty()) {
				predicateList.add(builder.like(builder.lower(root.get("firstName")),
						"%" + dto.getFirstName().toLowerCase() + "%"));
			}

			if (dto.getLastName() != null && !dto.getLastName().isEmpty()) {
				predicateList.add(
						builder.like(builder.lower(root.get("lastName")), "%" + dto.getLastName().toLowerCase() + "%"));
			}

			if (dto.getGender() != null && !dto.getGender().isEmpty()) {
				predicateList.add(builder.equal(builder.lower(root.get("gender")), dto.getGender().toLowerCase()));
			}

			if (dto.getEmailId() != null && !dto.getEmailId().isEmpty()) {
				predicateList.add(
						builder.like(builder.lower(root.get("emailId")), "%" + dto.getEmailId().toLowerCase() + "%"));
			}

			if (dto.getMobileNo() != null && !dto.getMobileNo().isEmpty()) {
				predicateList.add(builder.like(root.get("mobileNo"), "%" + dto.getMobileNo() + "%"));
			}

			if (dto.getCollegeId() > 0) {
				predicateList.add(builder.equal(root.get("collegeId"), dto.getCollegeId()));
			}

			if (dto.getCollegeName() != null && !dto.getCollegeName().isEmpty()) {
				predicateList.add(builder.like(builder.lower(root.get("collegeName")),
						"%" + dto.getCollegeName().toLowerCase() + "%"));
			}

			if (dto.getCourseId() > 0) {
				predicateList.add(builder.equal(root.get("courseId"), dto.getCourseId()));
			}

			if (dto.getCourseName() != null && !dto.getCourseName().isEmpty()) {
				predicateList.add(builder.like(builder.lower(root.get("courseName")),
						"%" + dto.getCourseName().toLowerCase() + "%"));
			}

			if (dto.getSubjectId() > 0) {
				predicateList.add(builder.equal(root.get("subjectId"), dto.getSubjectId()));
			}

			if (dto.getSubjectName() != null && !dto.getSubjectName().isEmpty()) {
				predicateList.add(builder.like(builder.lower(root.get("subjectName")),
						"%" + dto.getSubjectName().toLowerCase() + "%"));
			}

		}
		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));

		TypedQuery<FacultyDTO> query = entityManager.createQuery(cq);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List<FacultyDTO> list = query.getResultList();

		return list;

	}

}
