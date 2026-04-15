package com.calculator.app.service;

import org.springframework.stereotype.Service;

@Service 
public class RequestService {

	public double add(double a, double b) {
		return a + b;
	}
	
	public double sub(double a, double b) {
		return a - b;
	}
	
	public double multiply(double a, double b) {
		return a * b;
	}
	
	public double div(double a, double b) {
		if (b == 0) {
			throw new ArithmeticException("Division by zero is not possible");
		} 
		else 
			return a / b;
	}

}
