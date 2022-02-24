package com.abc.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.ecom.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}