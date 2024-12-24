package com.nikhil.orm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.orm.entities.Employee;
import com.nikhil.orm.payload.ApiResponseMessage;
import com.nikhil.orm.service.EmpService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmpService empService;
	
	
	@PostMapping("/createEmp")
	public ResponseEntity<Employee> createEmp(@RequestBody Employee emp){
		
		Employee savedEmp = empService.createEmp(emp);
		
		return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/updateEmp/{empId}")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp, @PathVariable String empId){
		
		Employee updatedEmp = empService.updateEmp(emp, empId);
		
		return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteEmp/{empId}")
	public ResponseEntity<ApiResponseMessage> deleteEmp(@PathVariable String empId) {
		
		ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder()
				.message("User is deleted successfully !!")
				.success(true)
				.status(HttpStatus.OK)
				.build();
		
		//delete emp
		empService.deleteEmp(empId);
		
		return new ResponseEntity<>(apiResponseMessage, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getAllEmp")
	public ResponseEntity<List<Employee>> getAllEmp(){
		
		List<Employee> allEmp = empService.getAllEmp();
		
		return new ResponseEntity<>(allEmp, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getEmpById/{empId}")
	public ResponseEntity<Employee> getEmpById(@PathVariable String empId){
		
		Employee empById = empService.getEmpById(empId);
		
		return new ResponseEntity<>(empById, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getEmpByEmail/{email}")
	public ResponseEntity<Employee> getEmpByEmail(@PathVariable String email){
		
		Employee empByEmail = empService.findByEmail(email);
		
		return new ResponseEntity<>(empByEmail, HttpStatus.OK);
		
	}

}

