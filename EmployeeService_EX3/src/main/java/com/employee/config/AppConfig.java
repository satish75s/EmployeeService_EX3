package com.employee.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.employee.dto.EmployeeResponse;
import com.employee.entity.Employee;

@Configuration
public class AppConfig {
	
	@Bean
	public ModelMapper modelMapper() {

	ModelMapper modelMapper = new ModelMapper();	
		
	TypeMap<Employee, EmployeeResponse> typeMap = modelMapper.createTypeMap(Employee.class, EmployeeResponse.class);	
	typeMap.addMappings(mapper -> {
				//Custom mapping if property names or types are different
				mapper.map(Employee::getId, EmployeeResponse::setEmpno);	
				mapper.map(Employee::getDoj, EmployeeResponse::setDateOfJoining);
		
			});
	return modelMapper;
		}


}
