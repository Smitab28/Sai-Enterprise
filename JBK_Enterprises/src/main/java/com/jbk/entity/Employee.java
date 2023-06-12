package com.jbk.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employeeId;
	@Column(unique=false)
	@NotEmpty(message="Employee name is manadatory")
	private String employeeName;
	@Column(unique=true)
	@NotEmpty(message="Employee email id is manadatory")
	private String employeeEmail;
	@Column(unique=true)
	@NotEmpty(message="Employee mobile is manadatory")
	private String employeeMobile;
	@Column(unique=false)
	@NotEmpty(message="Employee status is manadatory")
	private String employeeStatus;
	@Column(unique=false)
	@NotEmpty(message="Employee department is manadatory")
	private String employeeDepartment;
	private Date createdDate;
	private Date updatedDate;
	
	private String createdBy;
	private String updatedBy;
	@OneToOne
	private Country country;
	
	public Employee() {}
	
	public Employee(long employeeId, @NotEmpty(message = "Employee name is manadatory") String employeeName,
			@NotEmpty(message = "Employee email id is manadatory") String employeeEmail,
			@NotEmpty(message = "Employee mobile is manadatory") String employeeMobile,
			@NotEmpty(message = "Employee status is manadatory") String employeeStatus,
			@NotEmpty(message = "Employee department is manadatory") String employeeDepartment, Date createdDate,
			Date updatedDate, String createdBy, String updatedBy, Country country) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeeMobile = employeeMobile;
		this.employeeStatus = employeeStatus;
		this.employeeDepartment = employeeDepartment;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.country = country;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeMobile() {
		return employeeMobile;
	}

	public void setEmployeeMobile(String employeeMobile) {
		this.employeeMobile = employeeMobile;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeEmail="
				+ employeeEmail + ", employeeMobile=" + employeeMobile + ", employeeStatus=" + employeeStatus
				+ ", employeeDepartment=" + employeeDepartment + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", country=" + country + "]";
	}
	
	
	
	
}
