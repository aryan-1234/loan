package com.example.loanapplication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

public class LoanProcessorTest {
	
	@Mock
	private ScoreCalculator scoreCalculatorMock;
	
	@InjectMocks
	private LoanProcessor loanProcessorMock;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void isLoanApprovedTestWhenScoreIsLessThan576() {
		when(scoreCalculatorMock.calcFinalScore(30000, 0.2, "car", 10)).thenReturn(500);
		assertEquals(loanProcessorMock.isLoanApproved(30000, 6000, "car", 10), false);
	}
	
	@Test
	public void isLoanApprovedTestWhenScoreIsGreaterThanOrEqualTo576() {
		when(scoreCalculatorMock.calcFinalScore(30000, 0.2, "car", 20)).thenReturn(600);
		assertEquals(loanProcessorMock.isLoanApproved(30000, 6000, "car", 20), true);
	}
	
	@Test
	public void getLoanScoreTest() {
		when(scoreCalculatorMock.calcFinalScore(30000, 0.2, "car", 20)).thenReturn(500);
		assertEquals(loanProcessorMock.getLoanScore(30000, 6000, "car", 20), 500);
	}

}
