package com.example.loanapplication;

public class ContactInfo {
	
	private long homePhone;
	private Long officePhone;
	private long mobileNumber;
	private String email;
	
	
	public ContactInfo() {
		super();
	}


	public ContactInfo(long homePhone, Long officePhone, long mobileNumber, String email) {
		super();
		this.homePhone = homePhone;
		this.officePhone = officePhone;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}


	public long getHomePhone() {
		return homePhone;
	}


	public void setHomePhone(long homePhone) {
		this.homePhone = homePhone;
	}


	public Long getOfficePhone() {
		return officePhone;
	}


	public void setOfficePhone(Long officePhone) {
		this.officePhone = officePhone;
	}


	public long getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

}
