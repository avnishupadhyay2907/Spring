package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.StudentDTO;
import com.rays.service.StudentService;

@Component("testStudent")
public class TestStudent {

	@Autowired
	StudentService service;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestStudent test = context.getBean("testStudent", TestStudent.class);

		// test.testAdd();
		// test.testUpdate();
		// test.testDelete();
		// test.testFindByPk();
		// test.testAuth();
		test.testSearch();
	}

	private void testDelete() {

		StudentDTO dto = new StudentDTO();

		service.delete(2);

		System.out.println("Data deleted successfully at student");

	}

	private void testUpdate() {
		StudentDTO dto = new StudentDTO();
		dto.setId(2);
		dto.setFirstName("Avnish");
		dto.setLastName("Upadhyay");
		dto.setDob(new java.sql.Date(System.currentTimeMillis()));
		dto.setMobileNo("7648880017");
		dto.setLogin("uavnish2907@gmail.com");
		dto.setCollegeId(1);
		dto.setCollegeName("Vansha Groups Of Technology");
		service.update(dto);
		System.out.println("Data updated successfully at student id = " + dto.getId());

	}

	private void testAdd() {

		StudentDTO dto = new StudentDTO();

		dto.setId(2);
		dto.setFirstName("Avnish");
		dto.setLastName("Upadhyay");
		dto.setDob(new java.sql.Date(System.currentTimeMillis()));
		dto.setMobileNo("7648880017");
		dto.setLogin("uavnish2907@gmail.com");
		dto.setCollegeId(1);
		dto.setCollegeName("Vansha Groups Of College");
		int id = service.add(dto);

		System.out.println("Data inserted successfully at Student id = " + dto.getId());

	}

	public void testFindByPk() {
		StudentDTO dto = service.findByPK(2);
		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getDob());
			System.out.print("\t" + dto.getMobileNo());
			System.out.print("\t" + dto.getLogin());
			System.out.print("\t" + dto.getCollegeId());
			System.out.println("\t" + dto.getCollegeName());
		} else {
			System.out.println("Student ID not exist..!!!");
		}
	}

	public void testSearch() {

		StudentDTO dto = new StudentDTO();

		List<StudentDTO> list = service.search(dto, 0, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			dto = (StudentDTO) it.next();
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getDob());
			System.out.print("\t" + dto.getMobileNo());
			System.out.print("\t" + dto.getLogin());
			System.out.print("\t" + dto.getCollegeId());
			System.out.println("\t" + dto.getCollegeName());
		}
	}

}
