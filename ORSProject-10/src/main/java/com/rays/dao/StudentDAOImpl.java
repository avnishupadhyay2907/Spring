package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.CollegeDTO;
import com.rays.dto.StudentDTO;
import com.rays.dto.UserDTO;

@Repository
public class StudentDAOImpl extends BaseDAOImpl<StudentDTO> implements StudentDAOInt {

	@Autowired
	CollegeDAOInt collegeDao;

	@Override
	public Class<StudentDTO> getDTOClass() {
		return StudentDTO.class;
	}

	@Override
	protected void populate(StudentDTO dto, UserContext userContext) {

		if (dto.getCollegeId() != null && dto.getCollegeId() > 0) {
			CollegeDTO collegeDTO = collegeDao.findByPk(dto.getCollegeId(), userContext);
			dto.setCollegeName(collegeDTO.getName());
		}

	}

	@Override
	protected List<Predicate> getWhereClause(StudentDTO dto, CriteriaBuilder builder, Root<StudentDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isZeroNumber(dto.getId())) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isEmptyString(dto.getFirstName())) {
			whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
		}

		if (!isEmptyString(dto.getLastName())) {
			whereCondition.add(builder.like(qRoot.get("lastName"), dto.getLastName() + "%"));
		}

		if (dto.getDob() != null) {
			whereCondition.add(builder.equal(qRoot.get("dob"), dto.getDob()));
		}

		if (!isEmptyString(dto.getGender())) {
			whereCondition.add(builder.like(qRoot.get("gender"), dto.getGender() + "%"));
		}

		if (!isEmptyString(dto.getMobileNo())) {
			whereCondition.add(builder.like(qRoot.get("mobileNo"), dto.getMobileNo() + "%"));
		}

		if (!isEmptyString(dto.getEmail())) {
			whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));
		}

		if (!isZeroNumber(dto.getCollegeId())) {
			whereCondition.add(builder.equal(qRoot.get("collegeId"), dto.getCollegeId()));
		}
		if (!isEmptyString(dto.getCollegeName())) {
			whereCondition.add(builder.like(qRoot.get("collegeName"), dto.getCollegeName() + "%"));
		}
		return whereCondition;

	}

}
