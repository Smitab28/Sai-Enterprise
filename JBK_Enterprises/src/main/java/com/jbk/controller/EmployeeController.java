package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jbk.entity.Employee;
import com.jbk.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/add-employee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		String msg = employeeService.addEmployee(employee);
		return ResponseEntity.ok(msg);
	}
	
	@PutMapping("/update-employee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
		String msg = employeeService.updateEmployee(employee);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("/get-employee-by-id/{employeeId}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable long employeeId) {
		Employee employee = employeeService.getEmployeeByID(employeeId);
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping("/get-employee-name")
	public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String employeeName){
		List<Employee> employeeList = employeeService.getEmployeeByName(employeeName);
		return ResponseEntity.ok(employeeList);
	}
	
	@GetMapping("/get-all-employee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> employeeList = employeeService.getAllEmployee();
		return ResponseEntity.ok(employeeList);
	}
	
	@DeleteMapping("/delete-employee-by-id/{employeeId}")
	public ResponseEntity<String> deleteEmployeeByID(@PathVariable long employeeId) {
		String msg = employeeService.deleteEmployeeByID(employeeId);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("/get-employee-by-status/{employeeStatus}")
	public ResponseEntity<List<Employee>> getEmployeeByStatus(@PathVariable String employeeStatus){
		List<Employee> employeeList = employeeService.getEmployeeByStatus(employeeStatus);
		return ResponseEntity.ok(employeeList);
	}
}
