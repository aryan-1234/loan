package com.example.loanapplication.repository;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.loanapplication.model.Loan;


@Repository
public interface LoanRepository extends CrudRepository <Loan, Long>{
	
	@Modifying
	@Query("UPDATE Loan SET status = :status, declined_reason = :declined_reason, score=:score WHERE application_id = :application_id")
	void updateStatusReasonScore(@Param("status") String status,@Param("declined_reason") String declined_reason, @Param("score") int score, @Param("application_id") long application_id);
	
	
	@Modifying
	@Query("UPDATE Loan SET status = :status, declined_reason = :declined_reason WHERE application_id = :application_id")
	void updateStatusReason(@Param("status") String status,@Param("declined_reason") String declined_reason, @Param("application_id") long application_id);

}
