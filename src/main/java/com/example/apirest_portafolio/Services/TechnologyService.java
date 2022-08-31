package com.example.apirest_portafolio.Services;

import com.example.apirest_portafolio.Entitys.Technology;
import com.example.apirest_portafolio.Repositorys.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;

    public Technology addTechnology(Technology technology){
        return technologyRepository.save(technology);
    }

    public List<Technology> listTechnology(){return technologyRepository.findAll();}
}
