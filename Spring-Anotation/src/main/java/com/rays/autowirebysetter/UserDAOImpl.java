package com.rays.autowirebysetter;

import org.springframework.stereotype.Component;

@Component("userDaoS")
public class UserDAOImpl implements UserDAOInt {

	public void add() {

		System.out.println("In By Setter Add Method");

	}

}
