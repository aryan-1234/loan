package com.example.loanapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.loanapplication.model.User;


@Repository
public interface UserRepository extends CrudRepository <User, Long>{

}
