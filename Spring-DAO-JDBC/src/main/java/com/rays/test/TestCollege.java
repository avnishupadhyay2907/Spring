package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.CollegeDTO;
import com.rays.service.CollegeService;

@Component("testCollege")
public class TestCollege {

	@Autowired
	CollegeService service;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestCollege test = context.getBean("testCollege", TestCollege.class);

		// test.testAdd();
		// test.testUpdate();
		// test.testDelete();
		// test.testFindByPk();
		// test.testSearch();

	}

	private void testSearch() {

		CollegeDTO dto = new CollegeDTO();

		List<CollegeDTO> list = service.search(dto, 0, 2);

		Iterator<CollegeDTO> it = list.iterator();

		while (it.hasNext()) {

			dto = it.next();

			System.out.print(dto.getId());
			System.out.print("\t" + dto.getName());
			System.out.print("\t" + dto.getAddress());
			System.out.print("\t" + dto.getState());
			System.out.print("\t" + dto.getCity());
			System.out.print("\t" + dto.getPhone_No());

		}

	}

	private void testFindByPk() {

		CollegeDTO dto = service.findByPk(1);

		if (dto != null) {

			System.out.print(dto.getId());
			System.out.print("\t" + dto.getName());
			System.out.print("\t" + dto.getAddress());
			System.out.print("\t" + dto.getState());
			System.out.print("\t" + dto.getCity());
			System.out.print("\t" + dto.getPhone_No());

		} else {
			System.out.println("College Id Doesn't Exixst");
		}

	}

	private void testDelete() {

		service.delete(4);

		System.out.println("Data deleted successfully");

	}

	private void testUpdate() {

		CollegeDTO dto = new CollegeDTO();

		dto.setName("Vansha Institute Of Arts");
		dto.setAddress("Vijay Nagar");
		dto.setState("Madhya Pradesh");
		dto.setCity("Bhopal");
		dto.setPhone_No("7648880017");
		dto.setId(4);
		service.update(dto);

		System.out.println("Data updated successfully at college id = " + dto.getId());

	}

	private void testAdd() {

		CollegeDTO dto = new CollegeDTO();

		dto.setId(4);
		dto.setName("Vansha Institute Of Arts");
		dto.setAddress("Vijay Nagar");
		dto.setState("Madhya Pradesh");
		dto.setCity("Indore");
		dto.setPhone_No("7648880017");

		int id = service.add(dto);

		System.out.println("Data inserted successfully at college id = " + dto.getId());

	}

}
