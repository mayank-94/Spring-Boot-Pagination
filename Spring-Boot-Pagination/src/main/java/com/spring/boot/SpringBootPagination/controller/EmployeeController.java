/**
 * 
 */
package com.spring.boot.SpringBootPagination.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.SpringBootPagination.entity.Employee;
import com.spring.boot.SpringBootPagination.service.IEmployeeService;

import lombok.RequiredArgsConstructor;

/**
 * @author mayankjain
 *
 */
@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class EmployeeController {
	private  final IEmployeeService service;
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
		final Employee employee = service.findById(id);
		employee.add(linkTo(methodOn(EmployeeController.class).findAll()).withRel("all_employees"));
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@GetMapping("/employees/pagination")
	public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(defaultValue = "0") int pageNo, 
			@RequestParam(defaultValue = "3") int pageSize){
		final List<Employee> employees = service.findAllEmployees(pageNo, pageSize);
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> findAll(){
		final List<Employee> employees = service.findAll();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
}
