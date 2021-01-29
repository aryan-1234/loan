package com.example.loanapplication.controller;

import java.text.ParseException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.loanapplication.RequestBindingClass;
import com.example.loanapplication.model.Loan;
import com.example.loanapplication.model.User;
import com.example.loanapplication.service.LoanService;

@RestController
@CrossOrigin
public class MainRestController {
	
	@Autowired
	private LoanService service;
	
	
	
	@PostMapping("/save-loan")
	@Transactional
	public String saveLoan(@RequestBody RequestBindingClass requestclass) throws ParseException{
			User user = requestclass.createUserModel();
			Loan loan = requestclass.createLoanModel();
			service.saveLoan(loan,user);
			return "SUCCESSFUL";
	}
	
	@GetMapping("/all-app")
	public Iterable<Loan> getAllApplication(){
		return service.getAllApplication();
	}
	
	@GetMapping("/getById/{id}")
	public Loan getLoanById(@PathVariable long id) {
		Loan data1=service.getByAppId(id);
		return data1;
	}

}
