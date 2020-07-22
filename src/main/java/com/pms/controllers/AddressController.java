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
public class AddressController {
	
	
	@Autowired
	private PersonService personService;

		
	@RequestMapping(value = "/addressess", method = RequestMethod.GET)

	public String address(Model model) {
		model.addAttribute("address", new Address());
		model.addAttribute("addrList", personService.listAddresses());
		return "address";
	}
	
	//To add new address and edit address
	@RequestMapping(value = "/address/addaddress", method = RequestMethod.POST)
	public String addAddress(@ModelAttribute("address") Address address) throws PersonMgmtException {
		
		if(address.getStreet().length()<=0 ||address.getCity().length()<=0 || address.getState().length()<= 0 || address.getPostalCode()< 0)
		{
			throw new PersonMgmtException("Invalid inputs");
		}else {
		
		if (address.getAddressId()==null || address.getAddressId() == 0) {
			personService.addAddress(address);
		}else {
			personService.updateAddress(address);
		}
		
		}
		return "redirect:/addressess";
	}
	
	//To populate the address values in the fields for edit.
	@RequestMapping("/address/edit/{id}")
	public String editAddress(@PathVariable("id") int id, Model model) throws PersonMgmtException {
		
		if(id<=0) {
			throw new PersonMgmtException("Address Id does not exist");
		}else {
		model.addAttribute("address", personService.getAddressById(id));
		model.addAttribute("addrList", personService.listAddresses());
		}
		return "address";
	}
	
	@RequestMapping("/address/remove/{id}")
	public String removeAddress(@PathVariable("id") int id) throws PersonMgmtException {
		if(id<=0) {
			throw new PersonMgmtException("Address Id does not exist");
		}else {
		personService.removeAddress(id);
		}
		return "redirect:/addressess";
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
