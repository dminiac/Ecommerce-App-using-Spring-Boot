package com.abc.ecom.exception;

public class OrderNotFoundException extends RuntimeException {

	public OrderNotFoundException(String msg) {
		super(msg);
	}

}