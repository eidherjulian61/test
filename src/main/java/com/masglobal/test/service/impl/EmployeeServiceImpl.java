package com.masglobal.test.service.impl;

import com.masglobal.test.dto.EmployeePayload;
import com.masglobal.test.dto.HourlySalaryEmployeePayload;
import com.masglobal.test.dto.MonthlySalaryEmployeePayload;
import com.masglobal.test.exception.EmployeeNotFoundException;
import com.masglobal.test.model.Employee;
import com.masglobal.test.repository.EmployeeRepository;
import com.masglobal.test.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public static final String EMPLOYEE_NOT_FOUND = "Employee not found";
    public static final String HOURLY_SALARY_EMPLOYEE = "HourlySalaryEmployee";
    public static final String EMPTY = "";
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeePayload> getEmployees() {
        var employees = employeeRepository.getEmployees();
        List<EmployeePayload> response = new ArrayList<>();
        for (Employee employee : employees) {
            if (HOURLY_SALARY_EMPLOYEE.equals(employee.getContractTypeName())) {
                response.add(buildHourlySalaryEmployeePayload(employee));
            } else {
                response.add(buildMonthlySalaryEmployeePayload(employee));
            }
        }
        return response;
    }

    @Override
    public EmployeePayload getEmployee(String employeeId) {
        var employee = employeeRepository.getEmployee(Integer.parseInt(employeeId))
                .orElseThrow(() -> new EmployeeNotFoundException(EMPLOYEE_NOT_FOUND));
        if (HOURLY_SALARY_EMPLOYEE.equals(employee.getContractTypeName())) {
            return buildHourlySalaryEmployeePayload(employee);
        } else {
            return buildMonthlySalaryEmployeePayload(employee);
        }
    }

    private EmployeePayload buildHourlySalaryEmployeePayload(Employee employee) {
        return HourlySalaryEmployeePayload.builder()
                .hourlySalary(employee.getHourlySalary())
                .monthlySalary(employee.getMonthlySalary())
                .id(employee.getId())
                .name(employee.getName() == null ? EMPTY : employee.getName())
                .roleDescription(employee.getRoleDescription() == null ? EMPTY : employee.getRoleDescription())
                .roleId(employee.getRoleId())
                .roleName(employee.getRoleName() == null ? EMPTY : employee.getRoleName())
                .build();
    }

    private EmployeePayload buildMonthlySalaryEmployeePayload(Employee employee) {
        return MonthlySalaryEmployeePayload.builder()
                .hourlySalary(employee.getHourlySalary())
                .monthlySalary(employee.getMonthlySalary())
                .id(employee.getId())
                .name(employee.getName() == null ? EMPTY : employee.getName())
                .roleDescription(employee.getRoleDescription() == null ? EMPTY : employee.getRoleDescription())
                .roleId(employee.getRoleId())
                .roleName(employee.getRoleName() == null ? EMPTY : employee.getRoleName())
                .build();
    }
}
