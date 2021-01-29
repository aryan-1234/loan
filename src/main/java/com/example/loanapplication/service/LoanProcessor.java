package com.example.loanapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LoanProcessor {
	
	
	
	@Autowired
	private ScoreCalculator scoreCalculator;
	public boolean isLoanApproved(double annual_inc, double loan_amnt, String purpose, long id) {
		double debt_to_income_ratio = loan_amnt/annual_inc;
		int score = scoreCalculator.calcFinalScore(annual_inc, debt_to_income_ratio, purpose,id);
		if (score >= 576) return true;
		else return false;
	}
	
	public int getLoanScore(double annual_inc, double loan_amnt, String purpose, long id) {
		double debt_to_income_ratio = loan_amnt/annual_inc;
		return scoreCalculator.calcFinalScore(annual_inc, debt_to_income_ratio, purpose,id);
	}

}
