package com.abc.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Customer;
import com.abc.ecom.exception.CustomerNotFoundException;
import com.abc.ecom.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {

		Customer savedCustomer = customerRepository.save(customer);
		return savedCustomer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if (optionalCustomer.isEmpty()) {
			throw new CustomerNotFoundException("Sorry! Customer not found with id" + customerId);
		}
		return optionalCustomer.get();
	}

	@Override
	public void deleteCustomer(int customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if (optionalCustomer.isPresent()) {
			customerRepository.deleteById(customerId);
		} else {
			throw new CustomerNotFoundException("sorry customer is not existing with id:" + customerId);
		}
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
		if (optionalCustomer.isEmpty()) {
			throw new CustomerNotFoundException("Sorry! customer not found with id" + customer.getCustomerId());
		}
		Customer updatedCustomer = customerRepository.save(customer);
		return updatedCustomer;

	}

}