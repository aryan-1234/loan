package com.example.loanapplication.service;


import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loanapplication.model.BureauData;
import com.example.loanapplication.model.Loan;
import com.example.loanapplication.model.User;
import com.example.loanapplication.repository.BureauDataRepository;
import com.example.loanapplication.repository.LoanRepository;
import com.example.loanapplication.repository.UserRepository;

@Service
public class LoanService {
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private LoanProcessor loanscore;
	
	
	@Autowired 
	private LoanRepository loanrepo;
	
	@Autowired
	private BureauDataRepository bdrepo;
	
	public void checkFrontEndDeclineRules(Loan loan) {
		long rowCount = loanrepo.count();
		double salary = loan.getSalary();
		Integer workExpYear = ((loan.getWorkExpYear() != null) ?  loan.getWorkExpYear() : 0);
		Integer workExpMonth = ((loan.getWorkExpMonth() != null) ?  loan.getWorkExpMonth() : 0);
		Integer totalMonths = (workExpYear*12) + workExpMonth;
		LocalDate dob = loan.getUser().getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate currentDate = LocalDate.now();
		
		int years = Period.between(dob, currentDate).getYears();
		
		Optional<BureauData> ans = bdrepo.findById(loan.getUser().getSsn());
		if(ans.isPresent()) {
		
		
			if(years < 18 || years>65) {
				loanrepo.updateStatusReason("Declined", "Age should be between 18 and 65", rowCount);
			}
			else if(totalMonths < 6) {
				loanrepo.updateStatusReason("Declined", "Low Work Experience", rowCount);
			}
			else if(salary < 10000) {
				loanrepo.updateStatusReason("Declined", "Salary is less than $10,000", rowCount);
			}
			else {
				int result=loanscore.getLoanScore(loan.getSalary(), loan.getLoanAmount(), loan.getLoanPurpose(), loan.getUser().getSsn());
				if(result >= 576) {
					loanrepo.updateStatusReasonScore("Approved", "None", result, rowCount);
				}
				else {
					loanrepo.updateStatusReasonScore("Declined", "Low Score", result, rowCount);
				}
			}
		}
		else {
			loanrepo.updateStatusReasonScore("Declined", "Bureau Id missing in Bureau Table", 0, rowCount);
		}
		
	}
	
	public void saveLoan(Loan loan, User user) {
		userrepo.save(user);
		loanrepo.save(loan);
		checkFrontEndDeclineRules(loan);
	}
	
	public Iterable<Loan> getAllApplication(){
		return loanrepo.findAll();
	}
	
	public Loan getByAppId(long id) {
		Optional<Loan> ans= loanrepo.findById(id);
		if(ans.isPresent()) {
			return ans.get();
		}
		else {
			return null;
		}
	}

}
