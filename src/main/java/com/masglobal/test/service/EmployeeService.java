package com.masglobal.test.service;

import com.masglobal.test.dto.EmployeePayload;

import java.util.List;

public interface EmployeeService {
    List<EmployeePayload> getEmployees();

    EmployeePayload getEmployee(String employeeId);
}
