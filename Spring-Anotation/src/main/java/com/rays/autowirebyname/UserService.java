package com.rays.autowirebyname;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("userServiceN")
public class UserService {

	@Autowired
	@Qualifier("userDaoN")
	private UserDAOInt userDao;

	public void add() {
		userDao.add();
	}

}
