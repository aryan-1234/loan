package com.example.loanapplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loanapplication.model.BureauData;
import com.example.loanapplication.repository.BureauDataRepository;

@Service
public class BureauScoreCalculator {
		
	
	@Autowired
	private BureauDataRepository bdrepo;
	public int generateBureauScore(long id) {

		Optional<BureauData> ans = bdrepo.findById(id);
		BureauData bd = ans.get();
		return this.getBureauScore(bd.getDelinq_2yrs(), bd.getInq_last_6mths(), bd.getMths_since_last_delinq(), bd.getOpen_acc(), bd.getPub_rec(), bd.getRevol_util());
	}
	
	public int getBureauScore(int delinq_2yrs, int inq_last_6mths, int mths_since_last_delinq, int open_acc,
								int pub_rec, double revol_util) {
		int bureau_score = 0;
		
		if (delinq_2yrs == 0)
			bureau_score += 53;
		else if (delinq_2yrs == 1)
			bureau_score += 21;
		
		if (inq_last_6mths == 0)
			bureau_score += 60;
		else if (inq_last_6mths == 1 || inq_last_6mths == 2)
			bureau_score += 35;
		
		if (mths_since_last_delinq > 18 && mths_since_last_delinq <= 36)
			bureau_score += 12;
		else if (mths_since_last_delinq > 36 && mths_since_last_delinq <= 54)
			bureau_score += -33;
		else if (mths_since_last_delinq > 54 && mths_since_last_delinq < 120)
			bureau_score += -18;
		else if (mths_since_last_delinq >= 120)
			bureau_score += -4;
		
		if (open_acc <= 6)
			bureau_score += -19;
		else if (open_acc > 6 && open_acc <=10)
			bureau_score += -29;
		else if (open_acc > 10 && open_acc <= 14)
			bureau_score += -19;
		else if (open_acc > 14 && open_acc <= 20)
			bureau_score += -34;
		else if (open_acc > 20 && open_acc <= 30)
			bureau_score += -35;
		
		if (pub_rec == 0)
			bureau_score += 39;
		
		if (revol_util <= 0.1)
			bureau_score += 50;
		else if (revol_util > 0.1 && revol_util <= 0.2)
			bureau_score += 22;
		else if (revol_util > 0.2 && revol_util <= 0.3)
			bureau_score += 26;
		else if (revol_util > 0.3 && revol_util <= 0.4)
			bureau_score += 16;
		else if (revol_util > 0.4 && revol_util <= 0.5)
			bureau_score += -4;
		else if (revol_util > 0.5 && revol_util <= 0.6)
			bureau_score += 8;
		else if (revol_util > 0.6 && revol_util <= 0.7)
			bureau_score += -19;
		else if (revol_util > 0.7 && revol_util <= 0.8)
			bureau_score += -30;
		else if (revol_util > 0.8 && revol_util <= 0.9)
			bureau_score += -31;
		else if (revol_util > 0.9 && revol_util <= 1.0)
			bureau_score += -47;
		
		return bureau_score;
	}
}
