package com.example.loanapplication;

public class EmpAddress {
	
	private String empAddressLine1;
	private String empAddressLine2;
	private String empCity;
	private String empState;
	private int empPostalCode;
	
	
	public EmpAddress() {
		super();
	}


	public EmpAddress(String empAddressLine1, String empAddressLine2, String empCity, String empState,
			int empPostalCode) {
		super();
		this.empAddressLine1 = empAddressLine1;
		this.empAddressLine2 = empAddressLine2;
		this.empCity = empCity;
		this.empState = empState;
		this.empPostalCode = empPostalCode;
	}


	public String getEmpAddressLine1() {
		return empAddressLine1;
	}


	public void setEmpAddressLine1(String empAddressLine1) {
		this.empAddressLine1 = empAddressLine1;
	}


	public String getEmpAddressLine2() {
		return empAddressLine2;
	}


	public void setEmpAddressLine2(String empAddressLine2) {
		this.empAddressLine2 = empAddressLine2;
	}


	public String getEmpCity() {
		return empCity;
	}


	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}


	public String getEmpState() {
		return empState;
	}


	public void setEmpState(String empState) {
		this.empState = empState;
	}


	public int getEmpPostalCode() {
		return empPostalCode;
	}


	public void setEmpPostalCode(int empPostalCode) {
		this.empPostalCode = empPostalCode;
	}

}
