package com.abc.ecom.service;

import com.abc.ecom.entity.Order;

public interface OrderService {

	public Order saveOrder(Order order);

	public Order getOrderDetails(int orderId);

}