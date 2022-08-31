package com.example.apirest_portafolio.Controllers;

import com.example.apirest_portafolio.DTO.DTOimg;
import com.example.apirest_portafolio.Entitys.ImagenMain;
import com.example.apirest_portafolio.Services.ImagenMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/main")
public class ImagenMainController {

    @Autowired
    private ImagenMainService imgMain;

    @PostMapping()
    public ResponseEntity<ImagenMain> addMain(@RequestBody ImagenMain imagenMain){
        return new ResponseEntity<>(imgMain.addImagen(imagenMain), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<DTOimg>> listImgsMain(){
        return new ResponseEntity<>(imgMain.listImg(), HttpStatus.OK);
    }


}
