package com.rays.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserService;

@Component("testUser")
public class TestUser {

	@Autowired
	UserService service;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUser test = context.getBean("testUser", TestUser.class);

		// test.testAdd();
		// test.testUpdate();
		// test.testDelete();
		// test.testFindByPk();
		// test.testAuth();
		// test.testSearch();
	}

	private void testFindByPk() {
		UserDTO dto = service.findById(1);
		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("User ID not exist..!!!");
		}
	}

	private void testDelete() {

		service.delete(3);

	}

	private void testUpdate() {

		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("Avnish");
		dto.setLastName("Upadhyay");
		dto.setLogin("uavnish2907@gmail.com");
		dto.setPassword("pass123");

		service.save(dto);

		System.out.println("Data Save successfully.. ===>" + dto.getId());

	}

	private void testAdd() {

		UserDTO dto = new UserDTO();

		dto.setFirstName("Avnish");
		dto.setLastName("Upadhyay");
		dto.setLogin("avnish@gmail.com");
		dto.setPassword("pass123");

		service.save(dto);

		System.out.println("Data Save successfully.. ===>" + dto.getId());

	}

}
