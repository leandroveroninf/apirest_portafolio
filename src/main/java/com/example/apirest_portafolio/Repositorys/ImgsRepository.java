package com.example.apirest_portafolio.Repositorys;

import com.example.apirest_portafolio.Entitys.Imgs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgsRepository extends CrudRepository<Imgs, Integer> {
    List<Imgs> findAll();
}
