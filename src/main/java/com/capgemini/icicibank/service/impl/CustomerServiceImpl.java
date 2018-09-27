package com.capgemini.icicibank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.icicibank.entities.Customer;

import com.capgemini.icicibank.repository.CustomerRepository;
import com.capgemini.icicibank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
CustomerRepository customerRepository;
	@Override
	public Customer authenticate(Customer customer)  {
		// TODO Auto-generated method stub
		return customerRepository.authenticate(customer);
	}

	@Override
	public Customer updateProfile(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.updateProfile(customer);
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return customerRepository.updatePassword(customer, oldPassword, newPassword);
	}

}
