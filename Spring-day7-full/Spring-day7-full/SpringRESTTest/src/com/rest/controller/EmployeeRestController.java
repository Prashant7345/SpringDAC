package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.met.model.Employee;
import com.met.service.EmployeeService;

@RestController
@RequestMapping("/emp")
@CrossOrigin
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	//http://localhost:8055/SpringRESTTest/rest/emp/allEmps
	
	@GetMapping(value="allEmps", produces={MediaType.APPLICATION_JSON_VALUE})
	public List<Employee> getAllEmployees(){
		
		List<Employee> listEmployees = employeeService.getAllEmployees();
		System.out.println(listEmployees);
		
		return listEmployees;
		
	}
	
	
	//http://localhost:8055/SpringRESTTest/rest/emp/getEmp/12.json
	//http://localhost:8055/SpringRESTTest/rest/emp/getEmp/12.xml
	
	@GetMapping(value="getEmp/{id}", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> getEmployee(@PathVariable int id){
		
		Employee employee = employeeService.getEmployee(id);
		
		return new ResponseEntity<>(employee, HttpStatus.OK);
		
	}
	
	/*@GetMapping(value="getXMLEmp/{id}", produces={MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Employee> getXMLEmployee(@PathVariable int id){
		
		Employee employee = employeeService.getEmployee(id);
		
		return new ResponseEntity<>(employee, HttpStatus.OK);
		
	}*/
	
	//http://localhost:8055/SpringRESTTest/rest/emp/saveEmp
	
	@PostMapping(value="saveEmp", consumes={MediaType.APPLICATION_JSON_VALUE},
			produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		
		employeeService.saveEmployee(employee);
		
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
		
	}
	
	//@PutMapping
	//if new records created -> HTTPSTATUS.CREATED
	// if updated and response is created -> HTTPSTATUS.OK
		//if updated and no response is created -> HTTPSTATUS.NO_CONTENT 
	
	
	//@DeleteMapping
	
	
	
}




