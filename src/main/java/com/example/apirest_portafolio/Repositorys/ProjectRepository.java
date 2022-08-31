package com.example.apirest_portafolio.Repositorys;

import com.example.apirest_portafolio.Entitys.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {
    List<Project> findAll();
}
