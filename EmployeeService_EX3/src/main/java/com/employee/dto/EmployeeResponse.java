package com.employee.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
	
	int empno;
	String name;
	String contact;
	String email;
	LocalDate dateOfJoining;
	boolean isEmployee;
	double sal;


}
