package com.example.apirest_portafolio.Services;

import com.example.apirest_portafolio.DTO.DTOimg;
import com.example.apirest_portafolio.Entitys.Imgs;
import com.example.apirest_portafolio.Entitys.Project;
import com.example.apirest_portafolio.Repositorys.ImgsRepository;
import com.example.apirest_portafolio.Repositorys.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImgsService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ImgsRepository imgsRepository;

    public Imgs addImgs(Imgs imgs){
        Optional<Project> ProjectOpc = projectRepository.findById(imgs.getProject().getId());

        if(ProjectOpc.isPresent()){
            imgs.setProject(ProjectOpc.get());
            return imgsRepository.save(imgs);
        }

        return null;

    }

    public List<DTOimg> listImgs(){
        List<Imgs> imgsList = imgsRepository.findAll();
        List<DTOimg> dtOimgs = new ArrayList<>();

        for(Imgs imgs : imgsList){
            DTOimg dtOimg = new DTOimg();
            try{
                dtOimg.setImg(imgs.getImg());
                dtOimg.setIdProject(imgs.getProject().getId());
            }catch(Exception e){
                dtOimg.setIdProject(null);
            }

            dtOimgs.add(dtOimg);
        }

        return dtOimgs;

    }

}
