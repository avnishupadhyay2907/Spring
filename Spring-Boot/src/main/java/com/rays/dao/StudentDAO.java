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
import com.rays.dto.StudentDTO;

@Repository
public class StudentDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	CollegeDAO collegeDAO;

	public StudentDTO populateDto(StudentDTO dto) {

		CollegeDTO collegeDto = collegeDAO.findByPk(dto.getCollegeId());

		if (collegeDto != null) {

			dto.setCollegeName(collegeDto.getName());

		}
		return dto;

	}

	public long add(StudentDTO dto) {

		populateDto(dto);
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(StudentDTO dto) {

		populateDto(dto);
		entityManager.merge(dto); // merge method to insert or update

	}

	public void delete(long id) {

		StudentDTO dto = findByPk(id);

		entityManager.remove(dto); // remove method to delete

	}

	public StudentDTO findByPk(long id) {

		StudentDTO dto = entityManager.find(StudentDTO.class, id); // find method to find by id

		return dto;

	}

	public List<StudentDTO> search(StudentDTO dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<StudentDTO> cq = builder.createQuery(StudentDTO.class);

		Root<StudentDTO> root = cq.from(StudentDTO.class);

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

			if (dto.getMobileNo() != null && !dto.getMobileNo().isEmpty()) {
				predicateList.add(builder.like(root.get("mobileNo"), "%" + dto.getMobileNo() + "%"));
			}

			if (dto.getEmail() != null && !dto.getEmail().isEmpty()) {
				predicateList
						.add(builder.like(builder.lower(root.get("email")), "%" + dto.getEmail().toLowerCase() + "%"));
			}

			if (dto.getCollegeId() > 0) {
				predicateList.add(builder.equal(root.get("collegeId"), dto.getCollegeId()));
			}

			if (dto.getCollegeName() != null && !dto.getCollegeName().isEmpty()) {
				predicateList.add(builder.like(builder.lower(root.get("collegeName")),
						"%" + dto.getCollegeName().toLowerCase() + "%"));
			}

		}
		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));

		TypedQuery<StudentDTO> query = entityManager.createQuery(cq);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List<StudentDTO> list = query.getResultList();

		return list;

	}

}
