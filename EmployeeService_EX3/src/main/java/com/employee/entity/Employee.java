package com.employee.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="EMP_DETAILS")
public class Employee {
	@Id
	@GeneratedValue
	int id;	
	String name;
	String contact;
	String email;
	LocalDate doj;
	boolean isEmployee;
	double sal;

}
