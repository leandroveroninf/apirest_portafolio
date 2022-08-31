package com.example.apirest_portafolio.Repositorys;

import com.example.apirest_portafolio.Entitys.ImagenMain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagenMainRepository extends CrudRepository<ImagenMain, Integer> {
    List<ImagenMain> findAll();
}
