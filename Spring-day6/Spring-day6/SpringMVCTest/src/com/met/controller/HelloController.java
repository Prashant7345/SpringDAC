package com.met.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequestMapping("/hello")
public class HelloController {

	public HelloController(){
		System.out.println("HelloController  ::  Default const invoked");
	}
	
	//@RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public ModelAndView welcome(){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");				// setting english name of view
		
		modelAndView.addObject("welcomeMsg", "Welcome to SpringMVC");		// setting model data
		
		return modelAndView;
	}
	
	
	//http://localhost:8055/SpringMVCTest/mvc/hello/queryParam?username=Jack&age=22
	
	//http://localhost:8055/SpringMVCTest/mvc/hello/queryParam?uname=Jack&age=22
	
	
	//@RequestMapping(value="queryParam", method=RequestMethod.GET)
	@GetMapping("queryParam")
	public ModelAndView queryWelcome(@RequestParam(name="uname") String username, @RequestParam(required=false, defaultValue="22") int age){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");				// setting english name of view
		
		modelAndView.addObject("welcomeMsg", "Welcome to SpringMVC name " + username + " with age " + age);	
		return modelAndView;
	}
	
	
	//http://localhost:8055/SpringMVCTest/mvc/hello/pathVar/jack/22
	//http://localhost:8055/SpringMVCTest/mvc/hello/queryParam?uname=Jack&age=22
	
	@RequestMapping(value="pathVar/{name}/{age}", method=RequestMethod.GET)
	public ModelAndView pathVarWelcome(@PathVariable String name, @PathVariable int age){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");	
		
		modelAndView.addObject("welcomeMsg", "Welcome to SpringMVC name " + name + " with age " + age);	
		
		return modelAndView;
		
	}
}
