package com.capgemini.icicibank.controller;

import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.icicibank.entities.BankAccount;
import com.capgemini.icicibank.entities.Customer;
import com.capgemini.icicibank.exceptions.UserNotFoundException;
import com.capgemini.icicibank.service.CustomerService;

@Controller
@SessionAttributes("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/")
	public String sayHello(Model model) {
		model.addAttribute("customer", new Customer());
		return "login";
	}

	/*@RequestMapping(value = "/login1", method = RequestMethod.POST)
	public String authenticateCustomer(@RequestParam int custId, @RequestParam String password, HttpSession session,
			HttpServletRequest request) {
		Customer cust = customerService
				.authenticate(new Customer(custId, null, password, null, null, LocalDate.now(), null));
		session = request.getSession();
		session.setAttribute("customer", cust);
		return "index";

	}*/

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authenticateCustomer(@ModelAttribute("customer") Customer customer, Model model) {
		Customer c = customerService.authenticate(customer);

		customer.setAccount(c.getAccount());
		customer.setAddress(c.getAddress());
		customer.setEmail(c.getEmail());
		customer.setCustomerName(c.getCustomerName());
		customer.setDateOfBirth(c.getDateOfBirth());
		model.addAttribute("customer", customer);
		return "index";
	}

	@RequestMapping(value = "/editPage", method = RequestMethod.GET)
	public String updateCustomeru(HttpSession session, HttpServletRequest request, Model model) {

		session = request.getSession();
		Customer c = (Customer) session.getAttribute("customer");
		model.addAttribute("customer", c);
		return "edit";
	}

	/*
	 * @RequestMapping(value = "/edit4", method = RequestMethod.POST) public String
	 * updateCustomer(Model model, @RequestParam String custName, @RequestParam
	 * String address,
	 * 
	 * @RequestParam String email, HttpSession session, HttpServletRequest request)
	 * {
	 * 
	 * Customer customer = (Customer) session.getAttribute("customer"); session =
	 * request.getSession(); customer.setCustomerName(custName);
	 * customer.setAddress(address); customer.setEmail(email);
	 * customerService.updateProfile(customer); session.setAttribute("customer",
	 * customer);
	 * 
	 * return "edit"; }
	 */

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateCustomerq(@ModelAttribute Customer customer, HttpSession session, HttpServletRequest request) {

		// Customer customer = (Customer) session.getAttribute("customer");
		session = request.getSession();
		Customer account = (Customer) session.getAttribute("customer");
		customerService.updateProfile(customer);
		customer.setAccount(account.getAccount());
		session.setAttribute("customer", customer);

		return "edit";
	}

	@RequestMapping(value = "/changePasswordPage", method = RequestMethod.GET)
	public String changePasswordPage() {
		return "changePassword";
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePassword(Model model, HttpSession session, HttpServletRequest request,
			@RequestParam String oldPassword, @RequestParam String newPassword, @RequestParam String confirmPassword) {
		Customer customer = (Customer) session.getAttribute("customer");
		customerService.updatePassword(customer, oldPassword, newPassword);
		session.setAttribute("customer", customer);
		request.setAttribute("success", true);
		return "success";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getlogoutPage(HttpSession session) {
		session.invalidate();
		return "index";
	}

}
