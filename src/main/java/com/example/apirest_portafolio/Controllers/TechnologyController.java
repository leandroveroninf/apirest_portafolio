package com.example.apirest_portafolio.Controllers;

import com.example.apirest_portafolio.Entitys.Technology;
import com.example.apirest_portafolio.Services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/technology")
public class TechnologyController {

    @Autowired
    private TechnologyService technologyService;

    @PostMapping()
    public ResponseEntity<Technology> addTechnology(@RequestBody Technology technology){
        return new ResponseEntity<>(technologyService.addTechnology(technology), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Technology>> listTechnology(){
        return new ResponseEntity<>(technologyService.listTechnology(), HttpStatus.OK);
    }


}
