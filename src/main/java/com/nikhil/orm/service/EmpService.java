package com.nikhil.orm.service;

import java.util.List;

import com.nikhil.orm.entities.Employee;

public interface EmpService {
	
	//Create 
	
	public Employee createEmp(Employee employee);
	
	//update
	
	public Employee updateEmp(Employee employee, String empId);
	
	//delete
	
	public void deleteEmp(String empId);
	
	//get all emp
	
	public List<Employee> getAllEmp();
	
	//get single emp
	
	public Employee getEmpById(String empId);
	
	//get empl by email
	
	public Employee findByEmail(String email);
	

}
