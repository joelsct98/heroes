package com.example.heroes.entities;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
public class Heroes {

    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // constructores

    public Heroes() {
    }

    public Heroes(Long id, String name) {
        this.id = id;
        this.name = name;
    }

// getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
