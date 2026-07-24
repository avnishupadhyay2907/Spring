package com.rays.test;

import java.util.Iterator;
import java.util.List;

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
		test.testFindByPk();
		// test.testAuth();
		// test.testSearch();
	}

	private void testDelete() {

		service.delete(1);

	}

	private void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(1);
		dto.setFirstName("Vansha");
		dto.setLastName("Upadhyay");
		dto.setLogin("vansha2907@gmail.com");
		dto.setPassword("pass1234");
		service.update(dto);
		System.out.println("Data updated");

	}

	private void testAdd() {

		UserDTO dto = new UserDTO();

		dto.setId(2);
		dto.setFirstName("Avnish");
		dto.setLastName("Upadhyay");
		dto.setLogin("uavnish2907@gmail.com");
		dto.setPassword("pass123");

		int id = service.add(dto);

		System.out.println("Data inserted successfully at User id = " + id);

	}

	public void testFindByPk() {
		UserDTO dto = service.findByPK(2);
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

	public void testAuth() {
		UserDTO dto = service.authenticate("uavnish2907@gmail.com", "pass123");
		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("User not exist");
		}
	}

	public void testSearch() {

		UserDTO dto = new UserDTO();

		List<UserDTO> list = service.search(dto, 0, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			dto = (UserDTO) it.next();
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		}
	}

}
