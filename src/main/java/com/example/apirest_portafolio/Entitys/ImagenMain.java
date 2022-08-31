package com.example.apirest_portafolio.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ImagenMain")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImagenMain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String img;

    @OneToOne(mappedBy = "imgMain")
    @JsonIgnore
    private Project project;
}
