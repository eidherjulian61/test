package com.masglobal.test.controller;

import com.masglobal.test.dto.EmployeePayload;
import com.masglobal.test.exception.ArgumentRequiredException;
import com.masglobal.test.exception.EmployeeNotFoundException;
import com.masglobal.test.exception.ErrorResponse;
import com.masglobal.test.model.Employee;
import com.masglobal.test.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Get employees",
            notes = "Retrieve available employees",
            response = Employee.class,
            responseContainer = "List")

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request, Validation Fail", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorResponse.class)})
    public ResponseEntity<List<EmployeePayload>> getEmployees() {
        return ResponseEntity.ok().cacheControl(CacheControl.noCache())
                .body(employeeService.getEmployees());
    }

    @GetMapping(value = "/employees/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Employee", notes = "Retrieve Employee data", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request, Validation Fail", response = ArgumentRequiredException.class),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = EmployeeNotFoundException.class)})
    public ResponseEntity<EmployeePayload> getEmployee(
            @PathVariable String employeeId) {
        return ResponseEntity.ok().cacheControl(CacheControl.noCache())
                .body(employeeService.getEmployee(employeeId));
    }
}
