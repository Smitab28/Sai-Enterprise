package com.jbk.serviceIMPL;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jbk.dao.EmployeeDao;
import com.jbk.entity.Employee;
import com.jbk.service.EmployeeService;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public String addEmployee(Employee employee) {
		Date date = Date.valueOf(LocalDate.now());
		employee.setCreatedDate(date);
		String msg = employeeDao.addEmployee(employee);
		return msg;
	}

	@Override
	public String updateEmployee(Employee employee) {
		Date date = Date.valueOf(LocalDate.now());
		employee.setUpdatedDate(date);
		String msg = employeeDao.updateEmployee(employee);
		return msg;
	}

	@Override
	public Employee getEmployeeByID(long employeeId) {
		Employee employee= employeeDao.getEmployeeByID(employeeId);
		return employee;
	}

	@Override
	public List<Employee> getEmployeeByName(String employeeName) {
		List<Employee> employeeList = employeeDao.getEmployeeByName(employeeName);
		return employeeList;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employeeList = employeeDao.getAllEmployee();
		return employeeList;
	}

	@Override
	public String deleteEmployeeByID(long employeeId) {
		String msg = employeeDao.deleteEmployeeByID(employeeId);
		return msg;
	}

	@Override
	public List<Employee> getEmployeeByStatus(String employeeStatus) {
		List<Employee> employeeList = employeeDao.getEmployeeByStatus(employeeStatus);
		return employeeList;
	}

}
