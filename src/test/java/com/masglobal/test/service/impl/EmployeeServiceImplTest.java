package com.masglobal.test.service.impl;

import com.masglobal.test.model.Employee;
import com.masglobal.test.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void givenEmployeesWithTwoRecordsWhenCallGetEmployeesThenReturnListWithTwoElements() {
        Employee[] employees = new Employee[2];
        employees[0] = new Employee();
        employees[0].setContractTypeName("HourlySalaryEmployee");
        employees[1] = new Employee();
        employees[1].setContractTypeName("MonthlySalaryEmployee");
        given(employeeRepository.getEmployees())
                .willReturn(employees);
        var employeePayloadList = employeeService.getEmployees();
        then(employeeRepository)
                .should(times(1))
                .getEmployees();

        assertNotNull(employeePayloadList);
        assertFalse(employeePayloadList.isEmpty());
        assertEquals(2, employeePayloadList.size());
    }
}