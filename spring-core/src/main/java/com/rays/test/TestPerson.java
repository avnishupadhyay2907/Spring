package com.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class TestPerson {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("person.xml"));

		Person p = (Person) factory.getBean("person");

		System.out.println("Name- "+p.getName());
		System.out.println("Address- "+p.getAddress());

	}

}
