package com.example.loanapplication.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ScoreCalculator {
	
	@Autowired
	private BureauScoreCalculator bureauScoreCalculator;
	private int interceptScore = 498;
	
	public int calcBureauScore(long id) {

		return bureauScoreCalculator.generateBureauScore(id);
	}
	

	
	public int calcPurposeScore(String purpose) {
		if(purpose.equals("debt_consolidation"))
			return 52;
		else if(purpose.equals("credit_card"))
			return 87;
		else if(purpose.equals("other"))
			return 34;
		else if(purpose.equals("major_purchase") || purpose.equals("home_improvement"))
			return 55;
		else if(purpose.equals("car") || purpose.equals("small_business"))
			return 0;
		else
			return 37;
	}
	
	
	
	public int calcAnnualIncomeScore(double annual_inc) {
		if (annual_inc <= 26268)
			return -74;
		if (annual_inc > 26268 && annual_inc <= 38980)
			return -67;
		if (annual_inc > 38980 && annual_inc <= 51692)
			return -56;
		if (annual_inc > 51692 && annual_inc <= 64404)
			return -40;
		if (annual_inc > 64404 && annual_inc <= 77116)
			return -39;
		if (annual_inc > 77116 && annual_inc <= 96184)
			return -42;
		if (annual_inc > 96184 && annual_inc <= 140676)
			return -31;
		if (annual_inc > 140676 && annual_inc <= 210592)
			return -36;
		if (annual_inc > 210592 && annual_inc <= 332413)
			return -61;
		
		return 0;
	}
	
	public int calcDebtToIncomeScore(double debt_to_income_ratio) {
		if (debt_to_income_ratio <= 0.0561)
			return 51;
		if (debt_to_income_ratio > 0.0561 && debt_to_income_ratio <= 0.0886)
			return 46;
		if (debt_to_income_ratio > 0.0886 && debt_to_income_ratio <= 0.121)
			return 47;
		if (debt_to_income_ratio > 0.121 && debt_to_income_ratio <= 0.154)
			return 40;
		if (debt_to_income_ratio > 0.154 && debt_to_income_ratio <= 0.202)
			return 35;
		if (debt_to_income_ratio > 0.202 && debt_to_income_ratio <= 0.251)
			return 24;
		if (debt_to_income_ratio > 0.251 && debt_to_income_ratio <= 0.332)
			return 19;
		if (debt_to_income_ratio > 0.332 && debt_to_income_ratio <= 0.592)
			return -9;

		return 0;
	}
	
	
	
	public int calcFinalScore(double annual_inc, double debt_to_income_ratio, String purpose, long id) {
		int bureauScore = this.calcBureauScore(id);
		int annualIncomeScore = this.calcAnnualIncomeScore(annual_inc);
		int purposeScore = this.calcPurposeScore(purpose);
		int dtoiScore = this.calcDebtToIncomeScore(debt_to_income_ratio);
		return interceptScore + bureauScore + annualIncomeScore + purposeScore + dtoiScore;
	}

}
