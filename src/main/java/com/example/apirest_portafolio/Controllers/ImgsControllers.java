package com.example.apirest_portafolio.Controllers;

import com.example.apirest_portafolio.DTO.DTOimg;
import com.example.apirest_portafolio.Entitys.Imgs;
import com.example.apirest_portafolio.Services.ImgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/imgs")
public class ImgsControllers {

    @Autowired
    private ImgsService imgsService;

    @PostMapping()
    public ResponseEntity<Imgs> addImgs(@RequestBody Imgs imgs){
        return new ResponseEntity<>(imgsService.addImgs(imgs), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<DTOimg>> listImgs(){
        return new ResponseEntity<>(imgsService.listImgs(), HttpStatus.OK);
    }

}
