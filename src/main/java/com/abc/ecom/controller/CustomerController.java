package com.abc.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.abc.ecom.entity.Customer;
import com.abc.ecom.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@Api(value = "CustomerController")

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = "Save Customer Details", response = Customer.class, tags = "Save Customer")
	@PostMapping("/save")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerService.saveCustomer(customer);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
		return responseEntity;
	}

	@ApiOperation(value = "Get list of all customers", response = Iterable.class, tags = "Get All Customers")
	@GetMapping("/all")
	public List<Customer> fetchAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		return customers;
	}

	@ApiOperation(value = "Get specific Customer by customerId", response = Customer.class, tags = "Get Customer")

	@GetMapping("/get/{cid}")
	public ResponseEntity<?> fetchCustomerDetails(@PathVariable("cid") int customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Customer by customerId", tags = "Delete Customer")
	@DeleteMapping("/delete/{cid}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("cid") int customerId) {
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<>("Customer Deleted with id:" + customerId, HttpStatus.OK);
	}

	@ApiOperation(value = "Update Customer Details", response = Customer.class, tags = "Update Customer")
	@PutMapping("/update")
	public ResponseEntity<Customer> modifyCustomer(@RequestBody Customer customer) {
		Customer updatedCustomer = customerService.updateCustomer(customer);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}
}