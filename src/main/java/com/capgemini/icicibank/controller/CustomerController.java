package com.capgemini.icicibank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

	@RequestMapping("/l")
	public String sayHello() {
		return "index";
	}
	/*@RequestMapping(value = "/lindex", method = RequestMethod.GET)
	public String getHeaderPage()
	{
		return "header";
	}*/

}
