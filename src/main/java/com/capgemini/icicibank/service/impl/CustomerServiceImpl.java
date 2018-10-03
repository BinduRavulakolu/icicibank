package com.capgemini.icicibank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capgemini.icicibank.entities.Customer;
import com.capgemini.icicibank.exceptions.PasswordChangeException;
import com.capgemini.icicibank.exceptions.UpdationFailedException;
import com.capgemini.icicibank.exceptions.UserNotFoundException;
import com.capgemini.icicibank.repository.CustomerRepository;
import com.capgemini.icicibank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer authenticate(Customer customer) throws UserNotFoundException {
		try {
			return customerRepository.authenticate(customer);
		} catch (DataAccessException ex) {
			UserNotFoundException u = new UserNotFoundException("Customer not found");
			u.initCause(ex);
			throw u;
		}
	}

	@Override
	public Customer updateProfile(Customer customer) throws UpdationFailedException {
		try{
			return customerRepository.updateProfile(customer);
		}
		catch(DataAccessException ex)
		{
			UpdationFailedException e=new UpdationFailedException("Updation was failed");
			e.initCause(ex);
			throw e;
		}
	}
	

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		
			return customerRepository.updatePassword(customer, oldPassword, newPassword);
	
		

	}

}
