package com.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller

@RestController
@RequestMapping("/welcome")
public class WelcomeRESTController {

	//Spring supports REST Services -> @Controller + @ResponseBody
	
	
	//		@Controller + @ResponseBody -> @RESTController
	
/*	@GetMapping
	public @ResponseBody String welcome(){
		return "Welcome to Spring REST services";
	}*/
	
	
	/*@GetMapping
	//@RequestMapping(method=RequestMethod.GET)
	public String welcome(){
		return "Welcome to Spring REST services";
	}*/
	
	@GetMapping
	public ResponseEntity<String> welcome(){
		return new ResponseEntity<String>("Welcome to Spring REST services", HttpStatus.OK);
	}
	
	@GetMapping("/withHeaders")
	public ResponseEntity<String> welcomeWithHeaders(){
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("count", "2");
		
		
		return new ResponseEntity<String>("Welcome to Spring REST services", httpHeaders, HttpStatus.OK);
	}
	
	
	
}
