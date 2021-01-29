package com.example.loanapplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.loanapplication.model.Loan;
import com.example.loanapplication.model.User;

public class RequestBindingClass {
	private long ssn;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dob;
	private String maritalStatus;
	private double loanAmount;
	private String loanPurpose;
	private String description;
	private Address address;
	private ContactInfo contactInfo;
	private EmpDetails empDetails;
	
	public Date StringtoDate(String dob) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(dob);
		return date;
		
	}
	
	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public EmpDetails getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmpDetails empDetails) {
		this.empDetails = empDetails;
	}

	public User createUserModel() throws ParseException {
		Date d=StringtoDate(dob);
		User u=new User(ssn,firstName,middleName,lastName,d,maritalStatus);
		return u;
		
	}
	
	public Loan createLoanModel() throws ParseException {
		Date d=StringtoDate(dob);
		User u=new User(ssn,firstName,middleName,lastName,d,maritalStatus);
		Loan l=new Loan(loanAmount,loanPurpose,description,address.getAddressLine1(),address.getAddressLine2(),address.getCity(),
				address.getState(),address.getPostalCode(),contactInfo.getHomePhone(),contactInfo.getMobileNumber(),
				contactInfo.getOfficePhone(),contactInfo.getEmail(),empDetails.getEmployerName(),empDetails.getSalary(),
				empDetails.getDesignation(),empDetails.getEmpAddress().getEmpAddressLine1(),empDetails.getEmpAddress().getEmpAddressLine2(),
				empDetails.getEmpAddress().getEmpCity(),empDetails.getEmpAddress().getEmpState(),empDetails.getEmpAddress().getEmpPostalCode(),
				empDetails.getWorkExpYear(),empDetails.getWorkExpMonth(),u);
		
		return l;

		
		
		
	}
	
	

}
