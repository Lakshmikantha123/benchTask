package com.ey.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empDetails")
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String addressDetails;
    private String phoneNumber;
    private Integer experience;
    private String designation;
    @OneToMany(targetEntity = Project.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_proj_fk", referencedColumnName = "id")
    private List<Project> projectList;
}
