package com.employee.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeRequest;
import com.employee.dto.EmployeeResponse;
import com.employee.entity.Employee;
import com.employee.exceptions.ResourceNotFoundException;
import com.employee.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ModelMapper modelMapper;

	public EmployeeResponse addEmp(EmployeeRequest employeeRequest) {
		Employee employee = employeeRepository.save(modelMapper.map(employeeRequest, Employee.class));
		return modelMapper.map(employee, EmployeeResponse.class);
	}

	public EmployeeResponse updateEmp(int id, EmployeeRequest updateEmployeeRequest) {
		log.info("updating user with ID: {}", id);
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			Employee updateEmployeeEntity = modelMapper.map(updateEmployeeRequest, Employee.class);
			updateEmployeeEntity.setId(id);
			return modelMapper.map(employeeRepository.save(updateEmployeeEntity), EmployeeResponse.class);
		}
		throw new ResourceNotFoundException("no employee with id:" + id);
	}

	public void deleteEmp(int id) {
		log.info("deleting user with ID: {}", id);
		employeeRepository.deleteById(id);
	}

	public List<EmployeeResponse> getEmpList() {
		List<Employee> employee = employeeRepository.findAll();
		return employee.stream().map(c1 -> modelMapper.map(c1, EmployeeResponse.class)).collect(Collectors.toList());
	}

	public EmployeeResponse getEmpById(int id) {
		return modelMapper.map(employeeRepository.findById(id), EmployeeResponse.class);
	}

	public List<EmployeeResponse> fetchEmpByEmail(String email) {
		List<Employee> employee = employeeRepository.findByEmail(email);
		return employee.stream().map(c1 -> modelMapper.map(c1, EmployeeResponse.class)).collect(Collectors.toList());
	}

	public List<EmployeeResponse> findByDoj(LocalDate doj) {
		log.info("find by Doj: {}", doj);
		List<Employee> employee = employeeRepository.findByDoj(doj);
		return employee.stream().map(c1 -> modelMapper.map(c1, EmployeeResponse.class)).collect(Collectors.toList());
	}

	public List<EmployeeResponse> fetchByIsEmployee(boolean isEmployee) {
		List<Employee> employee = employeeRepository.findByIsEmployee(isEmployee);
		return employee.stream().map(c1 -> modelMapper.map(c1, EmployeeResponse.class)).collect(Collectors.toList());
	}

	public List<EmployeeResponse> getEmpListBySortField(String field) {
		List<Employee> employeeList = employeeRepository.findAll(Sort.by(field));
		return employeeList.stream().map(c1 -> modelMapper.map(c1, EmployeeResponse.class))
				.collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	public Page<EmployeeResponse> getEmpListByPageWise(int pageNo, int PageSize) {
		Pageable pageable = PageRequest.of(pageNo, PageSize);
		Page<Employee> employeeList = employeeRepository.findAll(pageable);
		return (Page<EmployeeResponse>) employeeList.stream().map(c1 -> modelMapper.map(c1, EmployeeResponse.class))
				.collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	public Page<EmployeeResponse> getEmpListByPageWiseBySortField(int pageNo, int PageSize, String field) {
		Pageable pageable = PageRequest.of(pageNo, PageSize, Sort.by(field));
		Page<Employee> employeeList = employeeRepository.findAll(pageable);
		return (Page<EmployeeResponse>) employeeList.stream().map(c1 -> modelMapper.map(c1, EmployeeResponse.class))
				.collect(Collectors.toList());
	}

}
