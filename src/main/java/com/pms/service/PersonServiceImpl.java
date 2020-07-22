package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pms.dao.PersonDAO;
import com.pms.model.Address;
import com.pms.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;

	public void setpersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	@Transactional
	public void addPerson(Person person) {
		personDAO.addPerson(person);
		
	}
	
	@Transactional
	public void updatePerson(Person person) {
		personDAO.updatePerson(person);
		
	}
	
	@Transactional
	public Person getPersonById(int id) {
		Person person = personDAO.getPersonById(id);
		return person;
	}
	
	@Transactional
	public void removePerson(int id) {
		personDAO.removePerson(id);
		
	}
	
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	@Transactional
	public void addAddress(Address address) {
		personDAO.addAddress(address);
		
	}

	@Transactional
	public List<Address> listAddresses() {
		List<Address> addrList = personDAO.listAddresses();
		return addrList;
	}

	@Transactional
	public Address getAddressById(int id) {
		Address address = personDAO.getAddressById(id);
		return address;
	}
	@Transactional
	public void updateAddress(Address address) {
		personDAO.updateAddress(address);
		
	}
	@Transactional
	public void removeAddress(int id) {
		personDAO.removeAddress(id);
	}
}
