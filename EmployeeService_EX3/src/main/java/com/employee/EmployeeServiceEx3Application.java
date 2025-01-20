package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	    info = @Info(
	        title = "Employee Management API",  
	        version = "1.0",                    
	        description = "This API manages employee records."
	    )
	)
public class EmployeeServiceEx3Application {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceEx3Application.class, args);
	}

}
