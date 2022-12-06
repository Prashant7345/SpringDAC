package com.met.cdac.springbootweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloRESTController {

	@GetMapping
	public String welcome(){
		return "Welcome to Spring boot REST services";
		
	}
	
}
