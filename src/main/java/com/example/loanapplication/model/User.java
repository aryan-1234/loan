package com.example.loanapplication.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="user")
public class User{
	
	@Id
	@Column(name="ssn")
	private long ssn;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="middleName", nullable = true)
	private String middleName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="dob")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name="maritalStatus")
	private String maritalStatus;

	public User() {}
	public User(long ssn, String firstName, String middleName, String lastName, Date dob, String maritalStatus) 
	{
		super();
		this.ssn = ssn;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.maritalStatus = maritalStatus;

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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}


	
	
	
	
	
	
	

}
