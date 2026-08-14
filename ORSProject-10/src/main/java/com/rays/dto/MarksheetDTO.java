package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_marksheet")
public class MarksheetDTO extends BaseDTO {

	@Column(name = "roll_no", length = 50)
	private String rollNo;

	@Column(name = "student_id")
	private Long studentId;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "physics")
	private int physics;

	@Column(name = "chemistry")
	private int chemistry;

	@Column(name = "maths")
	private int maths;

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "rollNo";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return rollNo;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Roll No";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Marksheet";
	}

}
