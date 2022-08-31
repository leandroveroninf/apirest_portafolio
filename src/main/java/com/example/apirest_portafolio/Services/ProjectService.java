package com.example.apirest_portafolio.Services;

import com.example.apirest_portafolio.Entitys.ImagenMain;
import com.example.apirest_portafolio.Entitys.Project;
import com.example.apirest_portafolio.Entitys.Technology;
import com.example.apirest_portafolio.Repositorys.ImagenMainRepository;
import com.example.apirest_portafolio.Repositorys.ProjectRepository;
import com.example.apirest_portafolio.Repositorys.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ImagenMainRepository imagenMainRepository;

    @Autowired
    private TechnologyRepository technologyRepository;

    public Project addProject(Project project, Integer idImgMain){

        Optional<ImagenMain> imagenMainOptional = imagenMainRepository.findById(idImgMain);

        if(imagenMainOptional.isPresent()){
            project.setImgMain(imagenMainOptional.get());
            return projectRepository.save(project);
        }

        return null;
    }

    public List<Project> listProject(){
        return projectRepository.findAll();
    }

    public Project addTechProject(Integer idProject, Integer idTech){
        Optional<Technology> technologyOptional = technologyRepository.findById(idTech);

        if(!technologyOptional.isPresent()){
            return null;
        }

        Optional<Project> projectOptional = projectRepository.findById(idProject);
        if(!projectOptional.isPresent()){
            return null;
        }

        List<Technology> technologyList = new ArrayList<>();

        technologyList.addAll(projectOptional.get().getTechnologies());
        technologyList.add(technologyOptional.get());

        projectOptional.get().setTechnologies(technologyList);

        return projectRepository.save(projectOptional.get());


    }

}
