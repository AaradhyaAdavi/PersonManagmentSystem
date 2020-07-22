package com.pms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pms.model.Address;
import com.pms.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO{
	
	@Autowired
	 private SessionFactory sessionFactory;

    @Transactional
	public void addPerson(Person person) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(person);
		
	}

	public void updatePerson(Person person) {
		Session session = sessionFactory.getCurrentSession();
		session.update(person);
	}

	public Person getPersonById(int id) {
		Session session = sessionFactory.getCurrentSession();		
		Person person = (Person) session.get(Person.class, new Integer(id));
		return person;
	}

	public void removePerson(int id) {
		Session session = sessionFactory.getCurrentSession();
		Person person = (Person) session.get(Person.class, new Integer(id));
		if(null != person){
			session.delete(person);
		}
	}

	//HQL
	public List<Person> listPersons() {
		Session session = sessionFactory.getCurrentSession();
		List<Person> EmployeesList = session.createQuery("from Person").list();
		return EmployeesList;
	}

	public void addAddress(Address address) {
		Session session = sessionFactory.getCurrentSession();
		Person person = (Person) session.get(Person.class, new Integer(address.getPerson_id()));
		//person.setAddr(address);
		address.setPerson(person);
		session.persist(address);
	}

	public void updateAddress(Address address) {
		Session session = sessionFactory.getCurrentSession();
		session.update(address);
		
	}

	public Address getAddressById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Address address = (Address)session.get(Address.class, new Integer(id));
		return address;
	}

	public List<Address> listAddresses() {
		Session session = sessionFactory.getCurrentSession();
		List<Address> addrList = session.createQuery("from Address").list();
		return addrList;
	}

	public void removeAddress(int id) {
		Session session = sessionFactory.getCurrentSession();
		Address address = (Address)session.get(Address.class, new Integer(id));
		if(address!=null) {
			session.delete(address);
		}
	}

	
}
