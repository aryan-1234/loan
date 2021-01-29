package com.example.loanapplication;

public class EmpDetails {
	
	private String employerName;
	private double salary;
	private Integer workExpYear;
	private Integer workExpMonth;
	private String designation;
	private EmpAddress empAddress;
	
	
	public EmpDetails() {
		super();
	}


	public EmpDetails(String employerName, double salary, Integer workExpYear, Integer workExpMonth, String designation,
			EmpAddress empAddress) {
		super();
		this.employerName = employerName;
		this.salary = salary;
		this.workExpYear = workExpYear;
		this.workExpMonth = workExpMonth;
		this.designation = designation;
		this.empAddress = empAddress;
	}


	public String getEmployerName() {
		return employerName;
	}


	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public Integer getWorkExpYear() {
		return workExpYear;
	}


	public void setWorkExpYear(Integer workExpYear) {
		this.workExpYear = workExpYear;
	}


	public Integer getWorkExpMonth() {
		return workExpMonth;
	}


	public void setWorkExpMonth(Integer workExpMonth) {
		this.workExpMonth = workExpMonth;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public EmpAddress getEmpAddress() {
		return empAddress;
	}


	public void setEmpAddress(EmpAddress empAddress) {
		this.empAddress = empAddress;
	}

}
