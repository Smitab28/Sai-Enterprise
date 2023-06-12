package com.jbk.service;

import java.util.List;

import com.jbk.entity.Employee;

public interface EmployeeService {

	public String addEmployee(Employee employee);
	public String updateEmployee(Employee employee);
	public Employee getEmployeeByID(long employeeId);
	public List<Employee> getEmployeeByName(String employeeName);
	public List<Employee> getAllEmployee();
	public String deleteEmployeeByID(long employeeId);
	public List<Employee> getEmployeeByStatus(String Status);
}
