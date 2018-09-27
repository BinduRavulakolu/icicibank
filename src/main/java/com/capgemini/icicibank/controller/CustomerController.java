package com.capgemini.icicibank.controller;

import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.icicibank.entities.BankAccount;
import com.capgemini.icicibank.entities.Customer;
import com.capgemini.icicibank.service.CustomerService;

@Controller
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
 
	
	
	@RequestMapping("/")
	public String sayHello() {
		return "login";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String authenticateCustomer(@RequestParam int custId, @RequestParam String password, HttpSession session, HttpServletRequest request) {
		Customer cust = customerService.authenticate(new Customer(custId, null, password, null, null, LocalDate.now(), null));
		session = request.getSession();
		session.setAttribute("customer", cust);
		return "index";
		
	}
	
	
	@RequestMapping(value = "/editPage", method = RequestMethod.GET)
	public String updateCustomeru(HttpSession session,HttpServletRequest request, Model model) {
		
		 session = request.getSession();
		Customer c = (Customer) session.getAttribute("customer");
     	model.addAttribute("customer", c);
		return "edit";
	}
	
	
	@RequestMapping(value = "/edit", method =  RequestMethod.POST)
	public String updateCustomer(Model model,@RequestParam String custName,@RequestParam String address,@RequestParam String email,HttpSession session,HttpServletRequest request) {
		 Customer cust=new Customer();
		 Customer customer= customerService.updateProfile(cust);
		 System.out.println(customer);
		 session= request.getSession();
		
		 customer.setCustomerName(custName);
		 customer.setAddress(address);
		 customer.setEmail(email);
		 
		 Customer c=(Customer) session.getAttribute("customer");
		 
		 
		 System.out.println(c);
     	model.addAttribute("customer", c);
		return "edit";
	}

}
