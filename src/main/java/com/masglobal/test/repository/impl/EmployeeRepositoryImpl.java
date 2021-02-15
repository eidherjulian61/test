package com.masglobal.test.repository.impl;

import com.masglobal.test.model.Employee;
import com.masglobal.test.repository.EmployeeRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private RestTemplate restTemplate = new RestTemplate();

    public Employee[] getEmployees() {
        return restTemplate.getForObject(
                "http://masglobaltestapi.azurewebsites.net/api/employees", Employee[].class);
    }

    public Optional<Employee> getEmployee(int id) {
        return Arrays.stream(getEmployees()).filter(employee -> employee.getId() == id).findFirst();
    }
}