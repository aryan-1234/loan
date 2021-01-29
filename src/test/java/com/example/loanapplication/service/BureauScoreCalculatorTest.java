package com.example.loanapplication.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.example.loanapplication.model.BureauData;
import com.example.loanapplication.repository.BureauDataRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;

public class BureauScoreCalculatorTest {

	@Mock
	private BureauDataRepository bdrepoMock;
	
	@Mock 
	private BureauData bdMock;
	
	@InjectMocks
	private BureauScoreCalculator bsCalculatorMock;
	
	@InjectMocks
	@Spy
	private BureauScoreCalculator bsCalculatorSpy;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void generateBureauScoreTest() {
		BureauData bd = new BureauData();
		when(bdrepoMock.findById((long) 10)).thenReturn(Optional.of(bd));
		bd.setDelinq_2yrs(1);
		bd.setInq_last_6mths(2);
		bd.setMths_since_last_delinq(3);
		bd.setOpen_acc(4);
		bd.setPub_rec(5);
		bd.setRevol_util(6);
		when(bsCalculatorSpy.getBureauScore(1, 2, 3, 4, 5, 6)).thenReturn(500);
		assertEquals(bsCalculatorSpy.generateBureauScore(10), 500);
	}
	
	@Test
	public void getBureauScoreTestAllFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 19, 5, 0, 0.1), 195);
	}
	
	@Test
	public void getBureauScoreTestDelinqIs1RestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(1, 0, 19, 5, 0, 0.1), 163);
	}
	
	@Test
	public void getBureauScoreTestDelinqIsNot0Or1RestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(2, 0, 19, 5, 0, 0.1), 142);
	}
	
	@Test
	public void getBureauScoreTestInqIs1RestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 1, 19, 5, 0, 0.1), 170);
	}
	
	@Test
	public void getBureauScoreTestInqIs2RestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 2, 19, 5, 0, 0.1), 170);
	}
	
	@Test
	public void getBureauScoreTestInqIsNot0Not1Not2RestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 3, 19, 5, 0, 0.1), 135);
	}
	
	@Test
	public void getBureauScoreTestMSLDFirstElseIfRestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 40, 5, 0, 0.1), 150);
	}
	
	@Test
	public void getBureauScoreTestMSLDSecondElseIfRestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 60, 5, 0, 0.1), 165);
	}
	
	@Test
	public void getBureauScoreTestMSLDThirdElseIfRestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 120, 5, 0, 0.1), 179);
	}
	
	@Test
	public void getBureauScoreTestMSLDLessThan18RestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 15, 5, 0, 0.1), 183);
	}
	
	@Test
	public void getBureauScoreTestOpenAccFirstElseIfRestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 19, 8, 0, 0.1), 185);
	}
	
	@Test
	public void getBureauScoreTestOpenAccSecondElseIfRestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 19, 12, 0, 0.1), 195);
	}
	
	@Test
	public void getBureauScoreTestOpenAccThirdElseIfRestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 19, 15, 0, 0.1), 180);
	}
	
	@Test
	public void getBureauScoreTestOpenAccFourthElseIfRestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 19, 25, 0, 0.1), 179);
	}
	
	@Test
	public void getBureauScoreTestOpenAccGreaterThan30RestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 19, 35, 0, 0.1), 214);
	}
	
	@Test
	public void getBureauScoreTestRevolUtilFirstElseIfRestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 19, 5, 0, 0.15), 167);
	}
	
	@Test
	public void getBureauScoreTestRevolUtilSecondElseIfRestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 19, 5, 0, 0.25), 171);
	}
	
	@Test
	public void getBureauScoreTestRevolUtilThirdElseIfRestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 19, 5, 0, 0.35), 161);
	}
	
	@Test
	public void getBureauScoreTestRevolUtilFourthElseIfRestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 19, 5, 0, 0.45), 141);
	}
	
	@Test
	public void getBureauScoreTestRevolUtilFifthElseIfRestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 19, 5, 0, 0.55), 153);
	}
	
	@Test
	public void getBureauScoreTestRevolUtilSixthElseIfRestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 19, 5, 0, 0.65), 126);
	}
	
	@Test
	public void getBureauScoreTestRevolUtilSeventhElseIfRestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 19, 5, 0, 0.75), 115);
	}
	
	@Test
	public void getBureauScoreTestRevolUtilEighthElseIfRestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 19, 5, 0, 0.85), 114);
	}
	
	@Test
	public void getBureauScoreTestRevolUtilNinthElseIfRestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 19, 5, 0, 0.95), 98);
	}
	
	@Test
	public void getBureauScoreTestRevolUtilGreaterThan1RestFirstIfs() {
		assertEquals(bsCalculatorMock.getBureauScore(0, 0, 19, 5, 0, 1.2), 145);
	}
}
