package com.masglobal.test.repository;

import com.masglobal.test.repository.impl.EmployeeRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = {EmployeeRepositoryImpl.class})
class ConsumerTest {

    @Autowired
    EmployeeRepository consumer;

    @Test
    void getEmployees() {
        var employees = consumer.getEmployees();
        assertTrue(employees.length > 0);
    }

    @Test
    void getEmployee() {
        var employee = consumer.getEmployee(1);
        assertFalse(employee.isEmpty());
    }
}