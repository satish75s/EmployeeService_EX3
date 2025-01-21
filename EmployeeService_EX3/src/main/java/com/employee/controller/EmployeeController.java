package com.employee.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeRequest;
import com.employee.dto.EmployeeResponse;
import com.employee.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/addEmp")
	public EmployeeResponse addEmp(@Valid @RequestBody EmployeeRequest employeeRequest) {
		log.info("Adding Employee:{}", employeeRequest.toString());
		return employeeService.addEmp(employeeRequest);
	}

	@PutMapping("/updateEmp/{id}")
	public EmployeeResponse updateEmp(@PathVariable int id, @Valid @RequestBody EmployeeRequest updateEmployeeRequest) {
		log.info("updating Employee:{} for emp id:{}", updateEmployeeRequest.toString(),id);
		return employeeService.updateEmp(id, updateEmployeeRequest);
	}

	@DeleteMapping("/delEmp/{id}")
	public void deleteEmp(@PathVariable int id) {
		log.info("deleting emp id:{}",id);
		employeeService.deleteEmp(id);
	}

	@GetMapping("/getEmpList")
	public List<EmployeeResponse> getEmpList() {
		return employeeService.getEmpList();
	}

	@GetMapping("/getEmpById/{id}")
	public EmployeeResponse getEmpById(@PathVariable int id) {
		return employeeService.getEmpById(id);
	}

	@GetMapping("/getEmpListByEmail/{email}")
	public List<EmployeeResponse> fetchEmpByEmail(@PathVariable String email) {
		return employeeService.fetchEmpByEmail(email);
	}

	@GetMapping("/getEmpListByDOJ")
	public List<EmployeeResponse> fetchEmpByDOJ(@RequestParam("doj") String doj) {
		LocalDate date = LocalDate.parse(doj);
		return employeeService.findByDoj(date);
	}

	@GetMapping("/IsEmployee/{isEmployee}")
	public List<EmployeeResponse> fetchByIsEmployee(@PathVariable boolean isEmployee) {
		return employeeService.fetchByIsEmployee(isEmployee);
	}

	@GetMapping("/getEmpListBySortByField/{field}")
	public List<EmployeeResponse> getEmpListBySortField(@PathVariable String field) {
		return employeeService.getEmpListBySortField(field);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/getEmpListByPage/{pageNo}/{PageSize}")
	public Page<EmployeeResponse> getEmpListByPageWise(@PathVariable int pageNo, @PathVariable int PageSize) {
		return employeeService.getEmpListByPageWise(pageNo, PageSize);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/getEmpListByPageAndSortbyField/{pageNo}/{PageSize}/{field}")
	public Page<EmployeeResponse> getEmpListByPageWiseBySortField(@PathVariable int pageNo, @PathVariable int PageSize,
			@PathVariable String field) {
		return employeeService.getEmpListByPageWiseBySortField(pageNo, PageSize, field);
	}
}
