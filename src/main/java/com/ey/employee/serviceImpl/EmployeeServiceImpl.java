package com.ey.employee.serviceImpl;

import com.ey.employee.entity.Employee;
import com.ey.employee.entity.Project;
import com.ey.employee.repository.EmployeeRepository;
import com.ey.employee.repository.ProjectRepository;
import com.ey.employee.response.EmployeeProjectResponse;
import com.ey.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Employee> getAllEmployeeDetails() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeDetailsById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        return null;
    }
    @Override
    public Employee saveEmployeeDetails(Employee employee) {
        Employee emp = employeeRepository.save(employee);
        return emp;
    }

    @Override
    public EmployeeProjectResponse getEmplProjDetailsById(Integer id) {
        Employee emp = employeeRepository.findById(id).get();
        List<Project> projectList = projectRepository.getEmpProjDetails(id);

        EmployeeProjectResponse employeeProjectResponse = new EmployeeProjectResponse();
        employeeProjectResponse.setEmployeeName(emp.getName());
        employeeProjectResponse.setDesignation(emp.getDesignation());
        employeeProjectResponse.setListOfProjects(projectList);
        return employeeProjectResponse;
    }
    @Override
    public void deleteEmployeeDetails(Integer id) {
        employeeRepository.deleteById(id);
    }
}
