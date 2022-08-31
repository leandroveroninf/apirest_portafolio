package com.example.apirest_portafolio.Entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imgMain")
    private ImagenMain imgMain;


    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Imgs> imgs;

    @ManyToMany
    @JoinTable(name = "project_technol",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "technol_id", referencedColumnName = "id")
    )
    private List<Technology> technologies;

}
