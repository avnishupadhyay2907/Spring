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
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;

@Repository
public class UserDAOImpl extends BaseDAOImpl<UserDTO> implements UserDAOInt {

	@Autowired
	RoleDAOInt roleDao;

	@Override
	protected void populate(UserDTO dto, UserContext userContext) {
		if (dto.getRoleId() != null && dto.getRoleId() > 0) {
			RoleDTO roleDto = roleDao.findByPk(dto.getRoleId(), userContext);
			dto.setRoleName(roleDto.getName());
		}
		if (dto.getId() != null && dto.getId() > 0) {
			UserDTO userData = findByPk(dto.getId(), userContext);
			dto.setLastLogin(userData.getLastLogin());
		}
	}

	@Override
	public Class<UserDTO> getDTOClass() {

		return UserDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(UserDTO dto, CriteriaBuilder builder, Root<UserDTO> qRoot) {

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
		if (!isEmptyString(dto.getLoginId())) {
			whereCondition.add(builder.like(qRoot.get("loginId"), dto.getLoginId() + "%"));
		}
		if (!isEmptyString(dto.getPassword())) {
			whereCondition.add(builder.like(qRoot.get("password"), dto.getPassword() + "%"));
		}
		if (!isEmptyString(dto.getRoleName())) {
			whereCondition.add(builder.like(qRoot.get("password"), dto.getPassword() + "%"));
		}
		if (!isZeroNumber(dto.getRoleId())) {
			whereCondition.add(builder.equal(qRoot.get("roleId"), dto.getRoleId()));
		}
		if (!isEmptyString(dto.getGender())) {
			whereCondition.add(builder.like(qRoot.get("gender"), dto.getGender() + "%"));
		}
		if (!isEmptyString(dto.getPhone())) {
			whereCondition.add(builder.like(qRoot.get("phone"), dto.getPhone() + "%"));
		}
		if (!isEmptyString(dto.getAlternateMobile())) {
			whereCondition.add(builder.like(qRoot.get("alternateMobile"), dto.getAlternateMobile() + "%"));
		}
		return whereCondition;
	}

}
