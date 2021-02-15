package com.masglobal.test.repository;

import com.masglobal.test.model.Employee;

import java.util.Optional;

public interface EmployeeRepository {

    Employee[] getEmployees();

    Optional<Employee> getEmployee(int id);
}