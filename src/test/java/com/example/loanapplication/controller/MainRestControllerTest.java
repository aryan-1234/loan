package com.example.loanapplication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.Mockito.*;


import com.example.loanapplication.RequestBindingClass;
import com.example.loanapplication.model.Loan;
import com.example.loanapplication.model.User;
import com.example.loanapplication.service.LoanService;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MainRestControllerTest {
	
	@Mock
	private LoanService loanServiceMock;
	
	@Mock
	private RequestBindingClass requestClassMock;
	
	@InjectMocks
	private MainRestController mainRestControllerMock;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	
	@Test
	public void saveLoanTest() throws ParseException {
		User user = new User();
		Loan loan = new Loan();
		when(requestClassMock.createUserModel()).thenReturn(user);
		when(requestClassMock.createLoanModel()).thenReturn(loan);
		String str = mainRestControllerMock.saveLoan(requestClassMock);
		verify(loanServiceMock, times(1)).saveLoan(loan, user);
		assertEquals(str, "SUCCESSFUL");
	}
	
	@Test
	public void getAllApplicationTest() {
		List<Loan> list = new ArrayList<Loan>();
		when(loanServiceMock.getAllApplication()).thenReturn(list);
		assertEquals(list, mainRestControllerMock.getAllApplication());
	}
	
	@Test
	public void getLoanByIdTest() {
		Loan loan = new Loan();
		when(loanServiceMock.getByAppId(10)).thenReturn(loan);
		assertEquals(loan, mainRestControllerMock.getLoanById(10));
	}
	
	
}
