package com.project.DisasterRecovery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String index()
	{
		return "Api testing";
	}
	
	@GetMapping("/home")
	public String index1()
	{
		return "home page";
	}
}
