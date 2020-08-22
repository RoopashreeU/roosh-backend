package com.roosh.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping(path = "/", produces = "application/json")
	public String sayHello() {
		return "Hello! Welcome to Roosh! A Scheduler Application.";
	}
	
}
