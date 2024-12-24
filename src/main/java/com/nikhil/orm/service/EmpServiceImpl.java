package com.nikhil.orm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.orm.entities.Employee;
import com.nikhil.orm.exception.ResourceNotFoundException;
import com.nikhil.orm.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepository empRepo;

	@Override
	public Employee createEmp(Employee employee) {

		// Generate unique id in string format
		String empId = UUID.randomUUID().toString();
		//set that id 
		employee.setEmpId(empId);

		// save employee
		Employee savedEmp = empRepo.save(employee);

		return savedEmp;
	}

	@Override
	public Employee updateEmp(Employee employee, String empId) {

		Employee updateEmp = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee not found by given id !!"));
	
		updateEmp.setName(employee.getName());
		updateEmp.setAge(employee.getAge());
		updateEmp.setEmail(employee.getEmail());

		Employee updatedEmp = empRepo.save(updateEmp);

		return updatedEmp;
	}

	@Override
	public void deleteEmp(String empId) {
		
		Employee emp = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee not found by given id !!"));

		empRepo.delete(emp);
		
	}

	@Override
	public List<Employee> getAllEmp() {

		List<Employee> allEmp = empRepo.findAll();

		return allEmp;
	}

	@Override
	public Employee getEmpById(String empId) {

		Employee emp = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee not found by given id !!"));

		return emp;
	}

	@Override
	public Employee findByEmail(String email) {
		
		Employee emp = empRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Employee not found by given email !!"));
		
		return emp;
	}

}
