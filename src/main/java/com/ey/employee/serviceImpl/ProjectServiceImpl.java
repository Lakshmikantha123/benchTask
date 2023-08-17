package com.ey.employee.serviceImpl;

import com.ey.employee.entity.Project;
import com.ey.employee.repository.ProjectRepository;
import com.ey.employee.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
