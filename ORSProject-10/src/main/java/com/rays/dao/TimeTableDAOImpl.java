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
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.dto.TimeTableDTO;

@Repository
public class TimeTableDAOImpl extends BaseDAOImpl<TimeTableDTO> implements TimeTableDAOInt {

	@Autowired
	CourseDAOInt courseDao;

	@Autowired
	SubjectDAOInt subjectDao;

	@Override
	public Class<TimeTableDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return TimeTableDTO.class;
	}

	@Override
	protected void populate(TimeTableDTO dto, UserContext userContext) {
		if (dto.getCourseId() != null && dto.getCourseId() > 0) {
			CourseDTO courseDTO = courseDao.findByPk(dto.getCourseId(), userContext);
			if (courseDTO != null) {
				dto.setCourseName(courseDTO.getName());
			}
		}

		if (dto.getSubjectId() != null && dto.getSubjectId() > 0) {
			SubjectDTO subjectDTO = subjectDao.findByPk(dto.getSubjectId(), userContext);
			if (subjectDTO != null) {
				dto.setSubjectName(subjectDTO.getName());
			}
		}
	}

	@Override
	protected List<Predicate> getWhereClause(TimeTableDTO dto, CriteriaBuilder builder, Root<TimeTableDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isZeroNumber(dto.getId())) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isEmptyString(dto.getSemester())) {
			whereCondition.add(builder.like(qRoot.get("semester"), dto.getSemester() + "%"));
		}

		if (!isEmptyString(dto.getDescription())) {
			whereCondition.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
		}

		if (!isEmptyString(dto.getExamTime())) {
			whereCondition.add(builder.like(qRoot.get("examTime"), dto.getExamTime() + "%"));
		}

		if (!isZeroNumber(dto.getCourseId())) {
			whereCondition.add(builder.equal(qRoot.get("courseId"), dto.getCourseId()));
		}

		if (!isEmptyString(dto.getCourseName())) {
			whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
		}

		if (!isZeroNumber(dto.getSubjectId())) {
			whereCondition.add(builder.equal(qRoot.get("subjectId"), dto.getSubjectId()));
		}

		if (!isEmptyString(dto.getSubjectName())) {
			whereCondition.add(builder.like(qRoot.get("subjectName"), dto.getSubjectName() + "%"));
		}
		return whereCondition;

	}

}
