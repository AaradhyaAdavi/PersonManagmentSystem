package com.pms.service;

import java.util.List;

import com.pms.model.Address;
import com.pms.model.Person;

public interface PersonService {
	
	public void addPerson(Person person);
	
	public void updatePerson(Person person);
	
	public Person getPersonById(int id);
	
	public void removePerson(int id);
	
	public List<Person> listPersons();

	public void addAddress(Address address);
	
	public Address getAddressById(int id);
	
	public void updateAddress(Address address);
	
	public void removeAddress(int id);
	
	public List<Address> listAddresses();
}
