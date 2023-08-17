package com.ey.employee.repository;

import com.ey.employee.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {
    @Query(value = "SELECT * FROM project_details u WHERE u.emp_proj_fk = :emp_proj_fk",
            nativeQuery = true)
    List<Project> getEmpProjDetails(@Param("emp_proj_fk") Integer id);
}
