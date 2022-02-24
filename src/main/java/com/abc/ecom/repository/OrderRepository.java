package com.abc.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.ecom.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}