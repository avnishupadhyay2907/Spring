package com.rays.autowirebytype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	@Autowired
	private UserDAOInt userDao;

	public void add() {
		userDao.add();
	}

}
