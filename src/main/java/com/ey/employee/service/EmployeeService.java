package com.ey.employee.service;

import com.ey.employee.entity.Employee;
import com.ey.employee.response.EmployeeProjectResponse;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployeeDetails();

    public Employee getEmployeeDetailsById(Integer id);

    public Employee saveEmployeeDetails(Employee employee);

    EmployeeProjectResponse getEmplProjDetailsById(Integer id);

    void deleteEmployeeDetails(Integer id);
}
