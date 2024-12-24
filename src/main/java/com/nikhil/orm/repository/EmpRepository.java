package com.nikhil.orm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.orm.entities.Employee;

public interface EmpRepository extends JpaRepository<Employee, String> {
	
	
	//custom finder method get emp by email
	public Optional<Employee> findByEmail(String email);

}
