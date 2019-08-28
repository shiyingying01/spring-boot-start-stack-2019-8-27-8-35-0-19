package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tw.apistackbase.domin.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
	List<Employee> employees = new ArrayList<Employee>();
	
	@GetMapping(path = "/")
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> getEmployees() {
		return employees;
	}

	@PostMapping(path = "/")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee createEmployee(@RequestBody Employee employee) {
		employees.add(employee);
		return employee;
	}
	
	@RequestMapping(path = "/{id}")
	public ResponseEntity<Employee> getOneEmployee(@PathVariable int id) {
		for(Employee employee : employees) {
			if (employee.getId()==(id)) {
				return ResponseEntity.ok(employee);
			}
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		for(Employee employee1 : employees) {
			if (employee.getId()==(id)) {
				employee1.setId(employee.getId());
				employee1.setName(employee.getName());
				employee1.setAge(employee.getAge());
				employee1.setGender(employee.getGender());
			}
			return ResponseEntity.ok(employee1);
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Employee> deleteEmployee( @PathVariable int id) {
		for(Employee employee1 : employees) {
			if (employee1.getId()==(id)) {
			employees.remove(employee1);
			}
			return ResponseEntity.ok(employee1);
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
}
