package com.rays.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rays.dto.CollegeDTO;

public class CollegeMapper implements RowMapper<CollegeDTO> {

	public CollegeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CollegeDTO college = new CollegeDTO();

		college.setId(rs.getInt(1));
		college.setName(rs.getString(2));
		college.setAddress(rs.getString(3));
		college.setState(rs.getString(4));
		college.setCity(rs.getString(5));
		college.setPhone_No(rs.getString(6));

		return college;
	}

}
