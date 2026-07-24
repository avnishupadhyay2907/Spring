package com.rays.autowired.bytype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("autowireByType.xml");

		UserService service = context.getBean("userService", UserService.class);

		service.add();

	}

}
