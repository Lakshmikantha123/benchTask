package com.ey.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="projectDetails")
public class Project {

    @Id
    @GeneratedValue
    private Integer projectId;
    private String projectName;
}
