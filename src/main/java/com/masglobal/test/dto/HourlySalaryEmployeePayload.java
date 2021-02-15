package com.masglobal.test.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HourlySalaryEmployeePayload implements EmployeePayload {

    private static final long serialVersionUID = 20210214L;

    private int id;
    private String name;
    private int roleId;
    private String roleName;
    private String roleDescription;
    private int hourlySalary;
    private int monthlySalary;
    private int calculatedAnnualSalary;

    @Override
    public int getCalculatedAnnualSalary() {
        return 120 * this.getHourlySalary() * 12;
    }
}
