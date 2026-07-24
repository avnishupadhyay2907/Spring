package com.rays.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rays.dto.StudentDTO;

public class StudentMapper implements RowMapper<StudentDTO> {

	public StudentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

		StudentDTO student = new StudentDTO();

		student.setId(rs.getInt(1));
		student.setFirstName(rs.getString(2));
		student.setLastName(rs.getString(3));
		student.setDob(rs.getDate(4));
		student.setMobileNo(rs.getString(5));
		student.setLogin(rs.getString(6));
		student.setCollegeId(rs.getInt(7));
		student.setCollegeName(rs.getString(8));

		return student;

	}

}
