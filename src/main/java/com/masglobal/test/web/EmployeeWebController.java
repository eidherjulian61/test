package com.masglobal.test.web;

import com.masglobal.test.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class EmployeeWebController {

    public static final String EMPTY = "";
    public static final String EMPLOYEES = "employees";
    public static final String EMPLOYEE_LIST = "employeeList";
    private static final String BASE_URL = "http://localhost:8080/employees";
    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/employeeList")
    public String employeeList(@RequestParam("employeeId") String id, Model model) {
        if (EMPTY.equalsIgnoreCase(id)) {
            Employee[] employees = restTemplate.getForObject(BASE_URL, Employee[].class);
            model.addAttribute(EMPLOYEES, employees);
        } else {
            String url = BASE_URL + "/{employeeId}";
            Employee employee = restTemplate.getForObject(url, Employee.class, id);
            model.addAttribute(EMPLOYEES, employee);
        }
        return EMPLOYEE_LIST;
    }
}
