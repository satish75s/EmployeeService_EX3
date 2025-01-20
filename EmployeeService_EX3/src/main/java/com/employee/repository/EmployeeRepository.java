package com.employee.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findByEmail(String email);

	public List<Employee> findByDoj(LocalDate  doj);

	public List<Employee> findByIsEmployee(boolean isEmployee);

}

