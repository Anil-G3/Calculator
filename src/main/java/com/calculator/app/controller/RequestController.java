package com.calculator.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.calculator.app.service.RequestService;

@Controller
@RequestMapping("/api")
public class RequestController {

	private final RequestService requestService;

	public RequestController(RequestService requestService) {
		this.requestService = requestService;
	}

	@GetMapping("/")
	public String showCalculator() {
		return "calculator";
	}

	@GetMapping("/calculate")
	public String calculate(@RequestParam double number1, @RequestParam double number2, @RequestParam String operation,
			Model model) {

		double solution = 0;

		switch (operation) {
		case "add":
			solution = requestService.add(number1, number2);
			break;

		case "sub":
			solution = requestService.sub(number1, number2);
			break;

		case "multiply":
			solution = requestService.multiply(number1, number2);
			break;

		case "divide":
			if (number2 == 0) {
				model.addAttribute("error", "Division by zero is not possible");
				return "calculator";
			}
			solution = requestService.div(number1, number2);
			break;

		default:
			model.addAttribute("error", "Invalid operation");
			return "calculator";
		}

		model.addAttribute("res", solution);

		return "result";
	}
}
