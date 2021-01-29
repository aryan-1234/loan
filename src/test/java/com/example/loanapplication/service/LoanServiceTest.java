package com.example.loanapplication.service;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.example.loanapplication.model.Loan;
import com.example.loanapplication.model.User;
import com.example.loanapplication.repository.LoanRepository;
import com.example.loanapplication.repository.UserRepository;

public class LoanServiceTest {

	@Mock
	private UserRepository userrepoMock;
	
	@Mock
	private LoanProcessor loanscoreMock;
	
	@Mock
	private LoanRepository loanrepoMock;
	
	@Mock
	private Loan loanMock;
	
	@Mock
	private User userMock;
	
	@InjectMocks
	private LoanService loanServiceMock;
	
	@InjectMocks
	@Spy
	private LoanService loanServiceSpy;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void checkFrontEndDeclineRulesTestWhenGetExpYearAndGetExpMonthReturnNotNullAndAgeIsLessThan18() throws ParseException {
		when(loanrepoMock.count()).thenReturn((long) 10);
		when(loanMock.getSalary()).thenReturn((double)30000);
		when(loanMock.getWorkExpYear()).thenReturn(5);
		when(loanMock.getWorkExpMonth()).thenReturn(6);
		when(loanMock.getUser()).thenReturn(userMock);
		String string = "01-01-2013";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dob = LocalDate.parse(string, dtf);
		Date dob2 = Date.from(dob.atStartOfDay(ZoneId.systemDefault()).toInstant());
		when(userMock.getDob()).thenReturn(dob2);
		loanServiceMock.checkFrontEndDeclineRules(loanMock);
		verify(loanrepoMock, times(1)).updateStatusReason("Declined", "Age should be between 18 and 65", 10);
	}
	
	@Test
	public void checkFrontEndDeclineRulesTestWhenGetExpYearAndGetExpMonthReturnNullAndAgeIsGreaterThan65() throws ParseException {
		when(loanrepoMock.count()).thenReturn((long) 10);
		when(loanMock.getSalary()).thenReturn((double)30000);
		when(loanMock.getWorkExpYear()).thenReturn(null);
		when(loanMock.getWorkExpMonth()).thenReturn(null);
		when(loanMock.getUser()).thenReturn(userMock);
		String string = "01-01-1900";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dob = LocalDate.parse(string, dtf);
		Date dob2 = Date.from(dob.atStartOfDay(ZoneId.systemDefault()).toInstant());
		when(userMock.getDob()).thenReturn(dob2);
		loanServiceMock.checkFrontEndDeclineRules(loanMock);
		verify(loanrepoMock, times(1)).updateStatusReason("Declined", "Age should be between 18 and 65", 10);
	}
	
	@Test
	public void checkFrontEndDeclineRulesTestWhenGetExpYearAndGetExpMonthReturnNotNullAndAgeIsBetween18And65ButTotalMonthsLessThan6() throws ParseException {
		when(loanrepoMock.count()).thenReturn((long) 10);
		when(loanMock.getSalary()).thenReturn((double)30000);
		when(loanMock.getWorkExpYear()).thenReturn(0);
		when(loanMock.getWorkExpMonth()).thenReturn(4);
		when(loanMock.getUser()).thenReturn(userMock);
		String string = "01-01-2000";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dob = LocalDate.parse(string, dtf);
		Date dob2 = Date.from(dob.atStartOfDay(ZoneId.systemDefault()).toInstant());
		when(userMock.getDob()).thenReturn(dob2);
		loanServiceMock.checkFrontEndDeclineRules(loanMock);
		verify(loanrepoMock, times(1)).updateStatusReason("Declined", "Low Work Experience", 10);
	}
	
	@Test
	public void checkFrontEndDeclineRulesTestWhenGetExpYearAndGetExpMonthReturnNotNullAndAgeIsBetween18And65AndTotalMonthsGreaterThan6ButSalaryLessThan10000() throws ParseException {
		when(loanrepoMock.count()).thenReturn((long) 10);
		when(loanMock.getSalary()).thenReturn((double)5000);
		when(loanMock.getWorkExpYear()).thenReturn(5);
		when(loanMock.getWorkExpMonth()).thenReturn(6);
		when(loanMock.getUser()).thenReturn(userMock);
		String string = "01-01-2000";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dob = LocalDate.parse(string, dtf);
		Date dob2 = Date.from(dob.atStartOfDay(ZoneId.systemDefault()).toInstant());
		when(userMock.getDob()).thenReturn(dob2);
		loanServiceMock.checkFrontEndDeclineRules(loanMock);
		verify(loanrepoMock, times(1)).updateStatusReason("Declined", "Salary is less than $10,000", 10);
	}
	
	@Test
	public void checkFrontEndDeclineRulesTestWhenGetExpYearAndGetExpMonthReturnNotNullAndAgeIsBetween18And65AndTotalMonthsGreaterThan6AndSalaryGreaterThan10000AndScoreLessThan576() throws ParseException {
		when(loanrepoMock.count()).thenReturn((long) 10);
		when(loanMock.getSalary()).thenReturn((double)30000);
		when(loanMock.getWorkExpYear()).thenReturn(5);
		when(loanMock.getWorkExpMonth()).thenReturn(6);
		when(loanMock.getUser()).thenReturn(userMock);
		String string = "01-01-2000";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dob = LocalDate.parse(string, dtf);
		Date dob2 = Date.from(dob.atStartOfDay(ZoneId.systemDefault()).toInstant());
		when(userMock.getDob()).thenReturn(dob2);
		when(userMock.getSsn()).thenReturn((long)100);
		when(loanMock.getLoanAmount()).thenReturn((double)5000);
		when(loanMock.getLoanPurpose()).thenReturn("car");
		when(loanscoreMock.getLoanScore((double)30000,(double)5000,"car",(long)100)).thenReturn(500);
		loanServiceMock.checkFrontEndDeclineRules(loanMock);
		verify(loanrepoMock, times(1)).updateStatusReasonScore("Declined", "Low Score", 500, 10);
	}
	
	@Test
	public void checkFrontEndDeclineRulesTestWhenGetExpYearAndGetExpMonthReturnNotNullAndAgeIsBetween18And65AndTotalMonthsGreaterThan6AndSalaryGreaterThan10000AndScoreGreaterThan576() throws ParseException {
		when(loanrepoMock.count()).thenReturn((long) 10);
		when(loanMock.getSalary()).thenReturn((double)30000);
		when(loanMock.getWorkExpYear()).thenReturn(5);
		when(loanMock.getWorkExpMonth()).thenReturn(6);
		when(loanMock.getUser()).thenReturn(userMock);
		String string = "01-01-2000";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dob = LocalDate.parse(string, dtf);
		Date dob2 = Date.from(dob.atStartOfDay(ZoneId.systemDefault()).toInstant());
		when(userMock.getDob()).thenReturn(dob2);
		when(userMock.getSsn()).thenReturn((long)100);
		when(loanMock.getLoanAmount()).thenReturn((double)5000);
		when(loanMock.getLoanPurpose()).thenReturn("car");
		when(loanscoreMock.getLoanScore((double)30000,(double)5000,"car",(long)100)).thenReturn(600);
		loanServiceMock.checkFrontEndDeclineRules(loanMock);
		verify(loanrepoMock, times(1)).updateStatusReasonScore("Approved", "None", 600, 10);
	}
	
	
	@Test
	public void saveLoanTest() {
		doNothing().when(loanServiceSpy).checkFrontEndDeclineRules(loanMock);
		loanServiceSpy.saveLoan(loanMock, userMock);
		verify(userrepoMock, times(1)).save(userMock);
		verify(loanrepoMock, times(1)).save(loanMock);
		verify(loanServiceSpy, times(1)).checkFrontEndDeclineRules(loanMock);
	}
	
	@Test
	public void getAllApplicationTest() {
		List<Loan> list = new ArrayList<Loan>();
		when(loanrepoMock.findAll()).thenReturn(list);
		assertEquals(loanServiceMock.getAllApplication(), list);
	}
	
	@Test
	public void getByAppIdWhenAnsIsNotPresent() {
		Optional<Loan> ans = Optional.empty();
		when(loanrepoMock.findById((long) 10)).thenReturn(ans);
		assertEquals(loanServiceMock.getByAppId(10), null);
	}
	
	@Test
	public void getByAppIdWhenAnsIsPresent() {
		loanMock.setApplicationId((long)10);
		Optional<Loan> ans = Optional.ofNullable(loanMock);
		when(loanrepoMock.findById((long) 10)).thenReturn(ans);
		assertEquals(loanServiceMock.getByAppId(10), ans.get());
	}
}
