package com.capgemini.icicibank.service;

import com.capgemini.icicibank.entities.Customer;


public interface CustomerService {
	public Customer authenticate(Customer customer) ;
	public Customer updateProfile(Customer customer);
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword);
	
}
