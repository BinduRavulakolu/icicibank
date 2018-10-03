package com.capgemini.icicibank;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.icicibank.controller.CustomerController;
import com.capgemini.icicibank.entities.BankAccount;
import com.capgemini.icicibank.entities.Customer;
import com.capgemini.icicibank.service.CustomerService;

public class CustomerControllerTest {

	@Mock
	private CustomerService customerService;

	@InjectMocks
	private CustomerController customerController;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@Test
	public void testAuthenticate() throws Exception {
		Customer customer1 = new Customer(12346, null, "bindu1", null, null, null, null);
		Customer customer = new Customer(12346, "swathi", "bindu1", "swathi@gmail.com", "hyderabad", LocalDate.now(),
				new BankAccount());

		when(customerService.authenticate(customer1)).thenReturn(customer);

		mockMvc.perform(post("/login").flashAttr("customer", customer1)).andExpect(view().name("index"))
				.andExpect(status().isOk());
	}
}
