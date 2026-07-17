package com.rays.autowirebytype;

import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAOInt {

	public void add() {

		System.out.println("In By Type Add Method");

	}

}
