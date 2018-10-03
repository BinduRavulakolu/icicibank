package com.capgemini.icicibank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.icicibank.exceptions.LowBalanceException;
import com.capgemini.icicibank.exceptions.UserNotFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value=UserNotFoundException.class)
	public String handleException1(UserNotFoundException ex,HttpServletRequest request) {
		
//		  request.setAttribute("success", false);
	      request.setAttribute("success", ex.toString());
	        return "success";
	}
	 
	@ExceptionHandler(value=LowBalanceException.class)
	public String handleException2(LowBalanceException ex,HttpServletRequest request) {
		
//		  request.setAttribute("success", false);
	      request.setAttribute("success", ex.toString());
	        return "success";
	}
	 
}
