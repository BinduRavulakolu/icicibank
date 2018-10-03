package com.capgemini.icicibank.service;

import com.capgemini.icicibank.entities.Customer;
import com.capgemini.icicibank.exceptions.UserNotFoundException;


public interface CustomerService {
	public Customer authenticate(Customer customer) throws UserNotFoundException ;
	public Customer updateProfile(Customer customer);
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword);
	
}
