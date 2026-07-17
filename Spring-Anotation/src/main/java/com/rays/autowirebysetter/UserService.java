package com.rays.autowirebysetter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("userServiceS")
public class UserService {

	private UserDAOInt userDao;

	@Autowired
	@Qualifier("userDaoS")
	public void setUserDao(UserDAOInt userDao) {
		this.userDao = userDao;
	}

	public void add() {
		userDao.add();
	}

}
