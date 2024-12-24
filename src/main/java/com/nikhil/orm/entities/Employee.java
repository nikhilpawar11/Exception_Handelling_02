package com.nikhil.orm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Emp_Table")
public class Employee {
	
	@Id
	@Column(name = "Emp_Id")
	private String empId;
	
	@Column(name = "Emp_Name")
	private String name;
	
	@Column(name = "Emp_Email")
	private String email;
	
	@Column(name = "Emp_Age")
	private int age;
	

}
