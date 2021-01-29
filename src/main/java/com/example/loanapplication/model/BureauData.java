package com.example.loanapplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bureaudata")
public class BureauData {
	
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="delinq_2yrs")
	private int delinq_2yrs;
	
	@Column(name="inq_last_6mths")
	private int inq_last_6mths;
	
	@Column(name="mths_since_last_delinq")
	private int mths_since_last_delinq;
	
	@Column(name="mths_since_last_record")
	private int mths_since_last_record;
	
	@Column(name="open_acc")
	private int open_acc;
	
	@Column(name="pub_rec")
	private int pub_rec;
	
	@Column(name="revol_bal")
	private int revol_bal;
	
	@Column(name="revol_util")
	private double revol_util;
	
	@Column(name="total_acc")
	private int total_acc;
	
	@Column(name="earliest_cr_line")
	private String earliest_cr_line;
	
	public BureauData() {}

	public BureauData(long id, int delinq_2yrs, int inq_last_6mths, int mths_since_last_delinq,
			int mths_since_last_record, int open_acc, int pub_rec, int revol_bal, double revol_util, int total_acc,
			String earliest_cr_line) {
		super();
		this.id = id;
		this.delinq_2yrs = delinq_2yrs;
		this.inq_last_6mths = inq_last_6mths;
		this.mths_since_last_delinq = mths_since_last_delinq;
		this.mths_since_last_record = mths_since_last_record;
		this.open_acc = open_acc;
		this.pub_rec = pub_rec;
		this.revol_bal = revol_bal;
		this.revol_util = revol_util;
		this.total_acc = total_acc;
		this.earliest_cr_line = earliest_cr_line;
	}

	public long getId() {
		return id;
	}

	public int getDelinq_2yrs() {
		return delinq_2yrs;
	}

	public int getInq_last_6mths() {
		return inq_last_6mths;
	}

	public int getMths_since_last_delinq() {
		return mths_since_last_delinq;
	}

	public int getMths_since_last_record() {
		return mths_since_last_record;
	}

	public int getOpen_acc() {
		return open_acc;
	}

	public int getPub_rec() {
		return pub_rec;
	}

	public int getRevol_bal() {
		return revol_bal;
	}

	public double getRevol_util() {
		return revol_util;
	}

	public int getTotal_acc() {
		return total_acc;
	}

	public String getEarliest_cr_line() {
		return earliest_cr_line;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDelinq_2yrs(int delinq_2yrs) {
		this.delinq_2yrs = delinq_2yrs;
	}

	public void setInq_last_6mths(int inq_last_6mths) {
		this.inq_last_6mths = inq_last_6mths;
	}

	public void setMths_since_last_delinq(int mths_since_last_delinq) {
		this.mths_since_last_delinq = mths_since_last_delinq;
	}

	public void setMths_since_last_record(int mths_since_last_record) {
		this.mths_since_last_record = mths_since_last_record;
	}

	public void setOpen_acc(int open_acc) {
		this.open_acc = open_acc;
	}

	public void setPub_rec(int pub_rec) {
		this.pub_rec = pub_rec;
	}

	public void setRevol_bal(int revol_bal) {
		this.revol_bal = revol_bal;
	}

	public void setRevol_util(double revol_util) {
		this.revol_util = revol_util;
	}

	public void setTotal_acc(int total_acc) {
		this.total_acc = total_acc;
	}

	public void setEarliest_cr_line(String earliest_cr_line) {
		this.earliest_cr_line = earliest_cr_line;
	}

	
	
	
	
	
	
	
	

}
