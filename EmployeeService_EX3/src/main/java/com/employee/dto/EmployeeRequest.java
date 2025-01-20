package com.employee.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

	// Name should not be empty or null, and should be between 2 and 100 characters.
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters")
    private String name;

    // Contact should be a non-empty string that matches a specific phone number pattern.
    @NotBlank(message = "Contact is mandatory")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact should be a 10-digit number")
    private String contact;

    // Email should be in a valid email format.
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    // Date of Joining should not be null
    @NotNull(message = "Date of Joining is mandatory")
    private LocalDate doj;

    // Employee status (isEmployee) should not be null
    @NotNull(message = "Employee status is mandatory")
    private boolean isEmployee;

    // Salary should be positive (greater than 0).
    @Min(value = 0, message = "Salary should be greater than or equal to 0")
    private double sal;

}
