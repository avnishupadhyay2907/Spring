package com.rays.autowirebyname;

import org.springframework.stereotype.Component;

@Component("userDaoN")
public class UserDAOImpl implements UserDAOInt {

	public void add() {

		System.out.println("In By Name Add Method");

	}

}
