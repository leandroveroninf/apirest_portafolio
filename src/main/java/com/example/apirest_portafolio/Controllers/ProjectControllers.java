package com.example.apirest_portafolio.Controllers;

import com.example.apirest_portafolio.Entitys.Project;
import com.example.apirest_portafolio.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/project")
public class ProjectControllers {

    @Autowired
    private ProjectService projectService;

    @GetMapping()
    public ResponseEntity<List<Project>> listProject(){
        return new ResponseEntity<>(projectService.listProject(), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Project> addProject(@PathVariable("id") Integer id, @RequestBody Project project){
        return new ResponseEntity<>(projectService.addProject(project, id), HttpStatus.CREATED);
    }

    @PutMapping("/{idProyect}/technology/{idTech}")
    public ResponseEntity<Project> addTechProject(@PathVariable("idProyect") Integer idProyect, @PathVariable("idTech") Integer idTech){
        return new ResponseEntity<>(projectService.addTechProject(idProyect, idTech), HttpStatus.OK);
    }

}
