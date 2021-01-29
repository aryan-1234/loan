package com.example.loanapplication.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.loanapplication.model.BureauData;


@Repository
public interface BureauDataRepository extends CrudRepository <BureauData, Long> {

}
