package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.StudentDTO;

@Repository
public class StudentDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public int add(StudentDTO dto) {

		String sql = "insert into st_student values (?,?,?,?,?,?,?,?)";

		jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getDob(), dto.getMobileNo(),
				dto.getLogin(), dto.getCollegeId(), dto.getCollegeName());

		return dto.getId();

	}

	public void update(StudentDTO dto) {

		String sql = "update st_student set first_name = ?, last_name = ?, dob = ?, mobile_no = ?, login = ?, college_id = ?, college_name = ? where id = ?";

		int i = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getDob(), dto.getMobileNo(),
				dto.getLogin(), dto.getCollegeId(), dto.getCollegeName(), dto.getId());

	}

	public void delete(int id) {

		String sql = "delete from st_student where id = ?";

		Object[] params = { id };

		int i = jdbcTemplate.update(sql, params);
	}

	public StudentDTO findByLogin(String login) {

		String sql = "select id, first_name, last_name, dob, mobile_no, login, college_id, college_name from st_student where login = ? ";

		Object[] params = { login };

		StudentDTO user = jdbcTemplate.queryForObject(sql, params, new StudentMapper());

		return user;

	}

	public StudentDTO findByPK(long pk) {

		String sql = "select id, first_name, last_name, dob, mobile_no, login, college_id, college_name from st_student where id = ?";

		Object[] params = { pk };
		List list = jdbcTemplate.query(sql, params, new StudentMapper());

		StudentDTO dto = null;

		if (list.size() > 0) {
			dto = (StudentDTO) list.get(0);
		}
		return dto;
	}

	public StudentDTO authenticate(String login, String password) {

		String sql = "select id, first_name, last_name, dob, mobile_no, login, college_id, college_name from st_student where login = ? and password = ?";

		Object[] params = { login, password };

		StudentDTO user = jdbcTemplate.queryForObject(sql, params, new StudentMapper());

		return user;

	}

	public List search(StudentDTO dto) {

		String sql = "select id, first_name, last_name, dob, mobile_no, login, college_id, college_name from st_student";

		List l = jdbcTemplate.query(sql, new StudentMapper());

		return l;
	}

	public List search(StudentDTO dto, int pageNo, int pageSize) {

		String sql = "select id, first_name, last_name, dob, mobile_no, login, college_id, college_name from st_student limit "
				+ pageNo + "," + pageSize;

		List l = jdbcTemplate.query(sql, new StudentMapper());

		return l;
	}

}