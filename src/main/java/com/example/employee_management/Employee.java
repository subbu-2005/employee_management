package com.example.employee_management;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Employee Entity representing the 'employees' table in the database.
 */
@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique ID for each employee

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name; // Employee name

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email; // Employee email (must be unique)

    @NotBlank(message = "Position is required")
    @Column(nullable = false)
    private String position; // Employee job position

    @NotBlank(message = "Department is required")
    @Column(nullable = false)
    private String department; // Department name

    @Min(value = 0, message = "Salary must be a positive value")
    @Column(nullable = false)
    private BigDecimal salary; // Employee salary
}
