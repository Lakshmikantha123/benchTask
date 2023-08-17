package com.ey.employee.controller;

import com.ey.employee.entity.Employee;
import com.ey.employee.entity.Project;
import com.ey.employee.response.EmployeeProjectResponse;
import com.ey.employee.service.EmployeeService;
import com.ey.employee.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ProjectService projectService;

    @GetMapping("/getAllEmployeeDetails")
    public ResponseEntity<List<Employee>> getEmployeeDetails() {
        List<Employee> listOfEmployees = employeeService.getAllEmployeeDetails();
        return new ResponseEntity<>(listOfEmployees, HttpStatus.OK);
    }

    @GetMapping("/getEmployeeDetailsById/{id}")
    public ResponseEntity<Employee> getEmployeeDetailsById(@PathVariable Integer id) {
        Employee employeeDetails = employeeService.getEmployeeDetailsById(id);
        return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
    }

    @PostMapping("/saveEmployeeDetails")
    public ResponseEntity<Employee> saveEmployeeDetails(@RequestBody Employee employee) {
        Employee savedEmplDetails = employeeService.saveEmployeeDetails(employee);
        return new ResponseEntity<>(savedEmplDetails, HttpStatus.CREATED);
    }
    @GetMapping("/getEmpProjDetailsById/{id}")
    public ResponseEntity<EmployeeProjectResponse> getEmpProjDetails(@PathVariable Integer id){
        EmployeeProjectResponse empProjResponse = employeeService.getEmplProjDetailsById(id);
        return new ResponseEntity<>(empProjResponse,HttpStatus.OK);
    }
    @GetMapping("/getAllProjects")
    public ResponseEntity<List<Project>> getAllProjects(){
        List<Project> projectList = projectService.getAllProjects();
        return new ResponseEntity<>(projectList,HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployeeDetails/{id}")
    public ResponseEntity<Void> deleteEmployeeDetails(@PathVariable Integer id){
        employeeService.deleteEmployeeDetails(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
