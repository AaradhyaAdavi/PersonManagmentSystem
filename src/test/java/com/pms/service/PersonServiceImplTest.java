package com.pms.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.List;

import com.pms.dao.PersonDAO;
import com.pms.model.Person;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mvc.xml")
public class PersonServiceImplTest {
	
	@Mock
	PersonDAO personDAO;
	
	PersonServiceImpl service = null; 
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		service = new PersonServiceImpl();
		service.setpersonDAO(personDAO);
	}
	
	@Test
	public void test() {
		Person person = new Person();
		personDAO.addPerson(person);
		verify(personDAO).addPerson(person);
		
	}
	
	@Test
	public void getPersonByIdTest() {
		when(personDAO.getPersonById(23)).thenReturn(new Person());
		Person person = personDAO.getPersonById(23);
		assertNotNull(person);
	}
	
	@Test
	public void removePersonTest() {
		personDAO.removePerson(30);
		verify(personDAO).removePerson(30);
		
	}
	
	public void listPersonsTest() {
		List<Person> listPersons = service.listPersons();
		assertNotNull(listPersons);
		verify(personDAO).listAddresses();
	}
	
	
	

}
