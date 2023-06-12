package com.jbk.DaoIMPL;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.EmployeeDao;
import com.jbk.entity.Employee;

@Repository
public class EmployeeDaoIMPL implements EmployeeDao {
	
	@Autowired
	SessionFactory sf;

	@Override
	public String addEmployee(Employee employee) {
		Session session=null;
		String msg = null;
		try {
			session = sf.openSession();
			Transaction tr = session.beginTransaction();
			session.save(employee);
			tr.commit();
			msg="Employee "+employee.getEmployeeName() +" added successfully";
		} catch(PersistenceException e) {
			msg="Employee already exist";
		}
		catch (Exception e) {
			e.printStackTrace();
			msg="Something went wrong";
		}finally {
			if(session!=null)
				session.close();
		}
		return msg;
	}

	@Override
	public String updateEmployee(Employee employee) {
		Session session=null;
		String msg = null;
		Employee updatedEmployee= null;
		try {
			session= sf.openSession();
			Transaction tr = session.beginTransaction();
			updatedEmployee = session.get(Employee.class, employee.getEmployeeId());
			if(updatedEmployee!=null) {
				updatedEmployee = employee;
				session.update(employee);
				tr.commit();
				msg="Employee "+employee.getEmployeeId() +" updated successfully";
			}else
				msg = "No such employee with ID:: "+employee.getEmployeeId();
		} 
		catch (Exception e) {
			e.printStackTrace();
			msg="Something went wrong";
		}finally {
			if(session!=null)
				session.close();
		}
		return msg;
	}

	@Override
	public Employee getEmployeeByID(long employeeId) {
		Session session = null;
		Employee employee = null;
		try {
			session = sf.openSession();
			employee = session.get(Employee.class, employeeId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session = null;
		List<Employee> employeeList = null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			employeeList = criteria.list();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public String deleteEmployeeByID(long employeeId) {
		Session session = null;
		Employee deleteEmployee=null;
		String msg=null;
		try {
			session = sf.openSession();
			deleteEmployee=session.get(Employee.class, employeeId);
			if(deleteEmployee!=null) {
				session.delete(deleteEmployee);
				msg=employeeId+" is deleted successfully";
			}else {
				msg="There is no employee with id:: "+employeeId;
			}
		}catch(Exception e) {
			e.printStackTrace();
			msg="unable to delete the employee with id:: "+employeeId;
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}

	@Override
	public List<Employee> getEmployeeByStatus(String employeeStatus) {
		Session session = null;
		List<Employee> employeeList = null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			List<Employee> empList = criteria.list();
			employeeList=empList.stream().filter(employee->employee.getEmployeeStatus().equalsIgnoreCase(employeeStatus)).collect(Collectors.toList());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeeByName(String employeeName) {
		Session session = null;
		List<Employee> employeeList = null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Employee.class);
			List<Employee> empList = criteria.list();
			employeeList = empList.stream().filter(employee->employee.getEmployeeName().equalsIgnoreCase(employeeName)).collect(Collectors.toList());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}

}
