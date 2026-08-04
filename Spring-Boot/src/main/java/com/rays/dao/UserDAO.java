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

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);

		Root<UserDTO> root = cq.from(UserDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {
			if (dto.getId() != null && dto.getId() > 0) {
				predicateList.add(builder.equal(root.get("id"), dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				predicateList.add(builder.like(root.get("firstName"), dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				predicateList.add(builder.like(root.get("lastName"), dto.getLastName() + "%"));
			}
			if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				predicateList.add(builder.like(root.get("login"), dto.getLogin() + "%"));
			}
			if (dto.getPassword() != null && dto.getPassword().length() > 0) {
				predicateList.add(builder.like(root.get("password"), dto.getPassword() + "%"));
			}
			if (dto.getRoleId() != null && dto.getRoleId() > 0) {
				predicateList.add(builder.equal(root.get("roleId"), dto.getRoleId()));
			}
			if (dto.getRoleName() != null && dto.getRoleName().length() > 0) {
				predicateList.add(builder.like(root.get("roleName"), dto.getRoleName() + "%"));
			}
		}
		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));

		TypedQuery<UserDTO> query = entityManager.createQuery(cq);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List<UserDTO> list = query.getResultList();

		return list;

	}

	public UserDTO findByUniqueKey(String attribute, String value) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);

		Root<UserDTO> qRoot = cq.from(UserDTO.class);

		Predicate condition = builder.equal(qRoot.get(attribute), value);

		cq.where(condition);

		TypedQuery<UserDTO> tq = entityManager.createQuery(cq);

		List<UserDTO> list = tq.getResultList();

		UserDTO dto = null;

		if (list.size() == 1) {
			dto = list.get(0);
		}

		return dto;
	}
}
