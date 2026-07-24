package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.CollegeDTO;

@Repository
public class CollegeDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public int add(CollegeDTO dto) {

		String sql = "insert into st_college values (?,?,?,?,?,?)";

		jdbcTemplate.update(sql, dto.getId(), dto.getName(), dto.getAddress(), dto.getState(), dto.getCity(),
				dto.getPhone_No());

		return dto.getId();

	}

	public void update(CollegeDTO dto) {

		String sql = "update st_college set name = ?, address = ? , state = ? , city = ? , phone_No = ? where id = ?";

		int i = jdbcTemplate.update(sql, dto.getName(), dto.getAddress(), dto.getState(), dto.getCity(),
				dto.getPhone_No(), dto.getId());
	}

	public void delete(int id) {

		String sql = "delete from st_college where id = ?";

		Object[] params = { id };

		int i = jdbcTemplate.update(sql, params);
	}

	public CollegeDTO findByName(String name) {

		String sql = "select id name , address , state , city , phone_No from st_college where name = ? ";

		Object[] params = { name };

		CollegeDTO college = jdbcTemplate.queryForObject(sql, params, new CollegeMapper());

		return college;

	}

	public CollegeDTO findByPK(int pk) {

		String sql = "select id,  name , address , state , city , phone_No from st_college where id = ?";

		Object[] params = { pk };
		List list = jdbcTemplate.query(sql, params, new CollegeMapper());

		CollegeDTO dto = null;

		if (list.size() > 0) {
			dto = (CollegeDTO) list.get(0);
		}
		return dto;
	}

	public List search(CollegeDTO dto) {

		String sql = "select id,  name , address , state , city , phone_No from st_college";

		List l = jdbcTemplate.query(sql, new CollegeMapper());

		return l;
	}

	public List search(CollegeDTO dto, int pageNo, int pageSize) {

		String sql = "select id,  name , address , state , city , phone_No from st_college limit " + pageNo + ","
				+ pageSize;

		List l = jdbcTemplate.query(sql, new CollegeMapper());

		return l;
	}

}
