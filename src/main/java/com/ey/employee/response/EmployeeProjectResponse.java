package com.ey.employee.response;

import com.ey.employee.entity.Employee;
import com.ey.employee.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProjectResponse {
  private String employeeName;
  private String designation;
  private List<Project> listOfProjects;
}
