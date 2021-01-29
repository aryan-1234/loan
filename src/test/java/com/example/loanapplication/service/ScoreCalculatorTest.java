package com.example.loanapplication.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ScoreCalculatorTest {
	
	@Mock
	private BureauScoreCalculator bureauScoreCalculatorMock;
	
	@InjectMocks
	private ScoreCalculator scoreCalculatorMock;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void calcBureauScoreTest() {
		when(bureauScoreCalculatorMock.generateBureauScore(10)).thenReturn(100);
		assertEquals(scoreCalculatorMock.calcBureauScore(10), 100);
	}
	
	@Test
	public void calcPurposeScoreTestWhenPurposeIsDebtConsolidation() {
		assertEquals(scoreCalculatorMock.calcPurposeScore("debt_consolidation"), 52);
	}
	
	@Test
	public void calcPurposeScoreTestWhenPurposeIsCreditCard() {
		assertEquals(scoreCalculatorMock.calcPurposeScore("credit_card"), 87);
	}
	
	@Test
	public void calcPurposeScoreTestWhenPurposeIsOther() {
		assertEquals(scoreCalculatorMock.calcPurposeScore("other"), 34);
	}
	
	@Test
	public void calcPurposeScoreTestWhenPurposeIsMajorPurchase() {
		assertEquals(scoreCalculatorMock.calcPurposeScore("major_purchase"), 55);
	}
	
	@Test
	public void calcPurposeScoreTestWhenPurposeIsHomeImprovement() {
		assertEquals(scoreCalculatorMock.calcPurposeScore("home_improvement"), 55);
	}
	
	@Test
	public void calcPurposeScoreTestWhenPurposeIsCar() {
		assertEquals(scoreCalculatorMock.calcPurposeScore("car"), 0);
	}
	
	@Test
	public void calcPurposeScoreTestWhenPurposeIsSmallBusiness() {
		assertEquals(scoreCalculatorMock.calcPurposeScore("small_business"), 0);
	}
	
	@Test
	public void calcPurposeScoreTestWhenPurposeIsNoneOfTheAbove() {
		assertEquals(scoreCalculatorMock.calcPurposeScore("wedding"), 37);
	}
	
	@Test
	public void calcAnnualIncomeScoreTestWhenAnnualIncomeIsLessThan26268() {
		assertEquals(scoreCalculatorMock.calcAnnualIncomeScore(20000), -74);
	}
	
	@Test
	public void calcAnnualIncomeScoreTestWhenAnnualIncomeIsBetween26268And38980() {
		assertEquals(scoreCalculatorMock.calcAnnualIncomeScore(30000), -67);
	}
	
	
	@Test
	public void calcAnnualIncomeScoreTestWhenAnnualIncomeIsBetween38980And51692() {
		assertEquals(scoreCalculatorMock.calcAnnualIncomeScore(40000), -56);
	}
	
	
	@Test
	public void calcAnnualIncomeScoreTestWhenAnnualIncomeIsBetween51692And64404() {
		assertEquals(scoreCalculatorMock.calcAnnualIncomeScore(55000), -40);
	}
	
	
	@Test
	public void calcAnnualIncomeScoreTestWhenAnnualIncomeIsBetween64404And77116() {
		assertEquals(scoreCalculatorMock.calcAnnualIncomeScore(70000), -39);
	}
	
	
	@Test
	public void calcAnnualIncomeScoreTestWhenAnnualIncomeIsBetween77116And96184() {
		assertEquals(scoreCalculatorMock.calcAnnualIncomeScore(90000), -42);
	}
	
	
	@Test
	public void calcAnnualIncomeScoreTestWhenAnnualIncomeIsBetween96184And140676() {
		assertEquals(scoreCalculatorMock.calcAnnualIncomeScore(100000), -31);
	}
	
	
	@Test
	public void calcAnnualIncomeScoreTestWhenAnnualIncomeIsBetween140676And210592() {
		assertEquals(scoreCalculatorMock.calcAnnualIncomeScore(150000), -36);
	}
	
	@Test
	public void calcAnnualIncomeScoreTestWhenAnnualIncomeIsBetween210592And332413() {
		assertEquals(scoreCalculatorMock.calcAnnualIncomeScore(250000), -61);
	}
	
	
	@Test
	public void calcAnnualIncomeScoreTestWhenAnnualIncomeIsGreaterThan332413() {
		assertEquals(scoreCalculatorMock.calcAnnualIncomeScore(400000), 0);
	}
	
	@Test
	public void calcDebtToIncomeScoreTestWhenDebtToIncomeRatioIsLessThanPoint0561() {
		assertEquals(scoreCalculatorMock.calcDebtToIncomeScore(0.0560), 51);
	}
	
	@Test
	public void calcDebtToIncomeScoreTestWhenDebtToIncomeRatioIsBetweenPoint0561AndPoint0886() {
		assertEquals(scoreCalculatorMock.calcDebtToIncomeScore(0.06), 46);
	}
	
	@Test
	public void calcDebtToIncomeScoreTestWhenDebtToIncomeRatioIsBetweenPoint0886AndPoint121() {
		assertEquals(scoreCalculatorMock.calcDebtToIncomeScore(0.1), 47);
	}
	
	@Test
	public void calcDebtToIncomeScoreTestWhenDebtToIncomeRatioIsBetweenPoint121AndPoint154() {
		assertEquals(scoreCalculatorMock.calcDebtToIncomeScore(0.13), 40);
	}
	
	@Test
	public void calcDebtToIncomeScoreTestWhenDebtToIncomeRatioIsBetweenPoint154AndPoint202() {
		assertEquals(scoreCalculatorMock.calcDebtToIncomeScore(0.17), 35);
	}
	
	@Test
	public void calcDebtToIncomeScoreTestWhenDebtToIncomeRatioIsBetweenPoint202AndPoint251() {
		assertEquals(scoreCalculatorMock.calcDebtToIncomeScore(0.21), 24);
	}
	
	@Test
	public void calcDebtToIncomeScoreTestWhenDebtToIncomeRatioIsBetweenPoint251AndPoint332() {
		assertEquals(scoreCalculatorMock.calcDebtToIncomeScore(0.3), 19);
	}
	
	@Test
	public void calcDebtToIncomeScoreTestWhenDebtToIncomeRatioIsBetweenPoint332AndPoint592() {
		assertEquals(scoreCalculatorMock.calcDebtToIncomeScore(0.4), -9);
	}
	
	@Test
	public void calcDebtToIncomeScoreTestWhenDebtToIncomeRatioIsGreaterThanPoint592() {
		assertEquals(scoreCalculatorMock.calcDebtToIncomeScore(0.6), 0);
	}
	
	@Test
	public void calcFinalScoreTest() {
		ScoreCalculator scoreCalculatorSpy = Mockito.spy(ScoreCalculator.class);
		doReturn(1).when(scoreCalculatorSpy).calcBureauScore(10);
		doReturn(2).when(scoreCalculatorSpy).calcAnnualIncomeScore(10000);
		doReturn(3).when(scoreCalculatorSpy).calcDebtToIncomeScore(0.2);
		doReturn(4).when(scoreCalculatorSpy).calcPurposeScore("car");
		assertEquals(scoreCalculatorSpy.calcFinalScore(10000, 0.2, "car", 10), 508);
	}
	
	
	
}
