package com.masglobal.test.model;

import lombok.Data;

@Data
public class Employee {

    private int id;
    private String name;
    private String contractTypeName;
    private int roleId;
    private String roleName;
    private String roleDescription;
    private int hourlySalary;
    private int monthlySalary;
    private int calculatedAnnualSalary;
}
