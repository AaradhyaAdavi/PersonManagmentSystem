package com.pms.dao;

import java.util.List;

import com.pms.model.Address;
import com.pms.model.Person;

public interface PersonDAO {
	
	public void addPerson(Person person);
	
	public void updatePerson(Person person);
	
	public Person getPersonById(int id);
	
	public void removePerson(int id);
	
	public List<Person> listPersons();
	
	
	public void addAddress(Address address);
	
	public void updateAddress(Address address);
	
	public Address getAddressById(int id);
	
	public void removeAddress(int id);
	
	public List<Address> listAddresses();
	

}
