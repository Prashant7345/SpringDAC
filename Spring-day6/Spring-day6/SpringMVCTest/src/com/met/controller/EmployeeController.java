package com.met.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.met.model.Employee;
import com.met.service.EmployeeService;

//@Component

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	//http://localhost:8055/SpringMVCTest/mvc/employee
	
	//EmployeeService employeeService = new EmployeeService();
	
	@Autowired	
	private EmployeeService employeeService;
	
	@GetMapping
	public ModelAndView initializeEmployee(){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("emp");
		
		Employee employ = new Employee();
		employ.setDesignation("Fresher");
		
		modelAndView.addObject("employee", employ);				//we have our default employee object as model
		
		List<Employee> listEmployees = employeeService.getAllEmployees();
		
		modelAndView.addObject("listEmployees", listEmployees);
		
		return modelAndView;
	}

	@PostMapping
	public ModelAndView saveEmployee(@ModelAttribute Employee employee){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("emp");
		
		System.out.println("Populated employee Object: " + employee);
		
		employeeService.saveEmployee(employee);
		
		//resetting form
		
		Employee employ = new Employee();
		employ.setDesignation("Fresher");
		
		modelAndView.addObject("employee", employ);	
		
		List<Employee> listEmployees = employeeService.getAllEmployees();
		
		modelAndView.addObject("listEmployees", listEmployees);
		
		//insert into employee table values (employee.getId, designation,email..)
		
		return modelAndView;
	}
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex, HttpServletRequest req){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		
		modelAndView.addObject("exMsg", ex.getMessage());
		
		modelAndView.addObject("exURL", req.getRequestURI());
		
		
		return modelAndView;
		
	}
	
	
	
}
