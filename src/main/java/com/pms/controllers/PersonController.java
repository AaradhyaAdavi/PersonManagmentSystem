package com.pms.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pms.exception.PersonMgmtException;
import com.pms.model.Address;
import com.pms.model.Person;
import com.pms.service.PersonService;

@Controller
public class PersonController {
	
	
	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("personList", personService.listPersons());
		return "person";
	}

	// Same method For both Add and Update person
	@RequestMapping(value = "/person/add", method = RequestMethod.POST)
	public String addperson(@ModelAttribute("person") Person person) throws PersonMgmtException {

		if(person.getFirstName().length()< 2||person.getLastName().length() < 2) {
			throw new PersonMgmtException("Invalid inputs");
			
		}else {
		
		if (person.getPersonId()==null || person.getPersonId() == 0) {
			// new Person, add it
			personService.addPerson(person);
		} else {
			// existing person, call update
			personService.updatePerson(person);
		}
		
		}

		return "redirect:/persons";

	}

	@RequestMapping("/person/remove/{id}")
	public String removeperson(@PathVariable("id") int id) throws PersonMgmtException {
		if(id<=0) {
			throw new PersonMgmtException("Person Id does not exist");
		}else {
			personService.removePerson(id);
		}
		return "redirect:/persons";
	}

	@RequestMapping("/person/edit/{id}")
	public String editperson(@PathVariable("id") int id, Model model) throws PersonMgmtException  {
		
		if(id<=0) {
			throw new PersonMgmtException("Person Id does not exist");
		}else {
		
			model.addAttribute("person", personService.getPersonById(id));
			model.addAttribute("personList", personService.listPersons());
		}
		return "person";
	}
	
	//Add address page
	@RequestMapping(value = "/address/add/{id}", method = RequestMethod.GET)
	public String address(@PathVariable("id") int id,Model model) {
		
		Address address = new Address();
		address.setPerson_id(id);
		model.addAttribute("address", address);
		model.addAttribute("addrList", personService.listAddresses());
		System.out.println("In path .../person/address/{id}--"+address.toString());
		return "address";
	}
	
	@ExceptionHandler(PersonMgmtException.class)
	public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}
	
}
