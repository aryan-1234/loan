package com.example.loanapplication.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="loan")
public class Loan {
	
	@Id
	@Column(name="applicationId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long applicationId;
	
	@Column(name="status",columnDefinition = "varchar(255) default 'In Progress'")
	private String status;
	
	@Column(name="score", nullable=true)
	private int score;
	
	@Column(name="declinedReason",columnDefinition = "varchar(255) default 'None'")
	private String declinedReason;
	
	@Column(name="created_at")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="loanAmount")
	private double loanAmount;
	
	@Column(name="loanPurpose")
	private String loanPurpose;
	
	@Column(name="description", nullable=true)
	private String description;
	
	@Column(name="addressLine1")
	private String addressLine1;
	
	@Column(name="addressLine2", nullable=true)
	private String addressLine2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="postalCode")
	private int postalCode;
	
	@Column(name="homePhone")
	private long homePhone;
	
	@Column(name="mobileNumber")
	private long mobileNumber;
	
	@Column(name="officePhone")
	private Long officePhone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="employerName")
	private String employerName;
	
	@Column(name="salary")
	private double salary;
	
	@Column(name="designation", nullable=true)
	private String designation;
	
	@Column(name="empAddressLine1")
	private String empAddressLine1;
	
	@Column(name="empAddressLine2",nullable=true)
	private String empAddressLine2;
	
	@Column(name="empCity")
	private String empCity;
	
	@Column(name="empState")
	private String empState;
	
	@Column(name="empPostalCode")
	private int empPostalCode;
	
	@Column(name="workExpYear", nullable=true)
	private Integer workExpYear;
	
	@Column(name="workExpMonth", nullable=true)
	private Integer workExpMonth;

	@ManyToOne
	@JoinColumn(name="user_ssn")
	private User user;
	
	public Loan() {}
	
	public Loan(double loanAmount, String loanPurpose, String description, String addressLine1, String addressLine2,
			String city, String state, int postalCode, long homePhone, long mobileNumber, Long officePhone,
			String email, String employerName, double salary, String designation, String empAddressLine1,
			String empAddressLine2, String empCity, String empState, int empPostalCode , Integer workExpYear,
			Integer workExpMonth, User user) {
		super();
		this.loanAmount = loanAmount;
		this.loanPurpose = loanPurpose;
		this.description = description;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.homePhone = homePhone;
		this.mobileNumber = mobileNumber;
		this.officePhone = officePhone;
		this.email = email;
		this.employerName = employerName;
		this.salary = salary;
		this.designation = designation;
		this.empAddressLine1 = empAddressLine1;
		this.empAddressLine2 = empAddressLine2;
		this.empCity = empCity;
		this.empState = empState;
		this.empPostalCode = empPostalCode;
		this.workExpYear = workExpYear;
		this.workExpMonth = workExpMonth;
		this.user = user;
	}

	public long getApplicationId() {
		return applicationId;
	}
	
	

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDeclinedReason() {
		return declinedReason;
	}

	public void setDeclinedReason(String declinedReason) {
		this.declinedReason = declinedReason;
	}
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	public LocalDateTime getCreatedAt() {
		return createdAt;
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

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public long getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(long homePhone) {
		this.homePhone = homePhone;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(Long officePhone) {
		this.officePhone = officePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	public int getEmppostalCode() {
		return empPostalCode;
	}

	public void setEmpPostalCode(int empPostalCode) {
		this.empPostalCode = empPostalCode;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	
	

}
