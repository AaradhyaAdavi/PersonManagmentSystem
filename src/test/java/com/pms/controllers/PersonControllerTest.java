package com.pms.controllers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pms.exception.PersonMgmtException;
import com.pms.model.Person;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mvc.xml")
public class PersonControllerTest {
	
	@Autowired
	private PersonController controller;


	@Test
	public void addPersonsTest() throws PersonMgmtException {
		
		/*
		 * Person person = new Person(); person.setPersonId(101);
		 * person.setFirstName("test"); person.setLastName("test"); String addperson =
		 * controller.addperson(person); assertNotNull(addperson);
		 */
		
	}
	
	@Test
	public void removepersonTest() throws PersonMgmtException {
		
		
	}
	
}
