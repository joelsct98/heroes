package com.example.heroes.controller;


import com.example.heroes.entities.Heroes;
import com.example.heroes.repository.HeroesRepository;
import com.example.heroes.service.HeroesService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HeroesController {

    private final Logger log = LoggerFactory.getLogger(HeroesController.class);

    private HeroesRepository heroesRepository;

    private HeroesService heroesService;

    public HeroesController(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }

    @GetMapping("/heroes/findAll")
    public List<Heroes> findAll(){
        return heroesRepository.findAll();
    }

    @GetMapping("/heroes/findOneById/{id}")
    public ResponseEntity<Heroes> findOneById(@PathVariable Long id){

        Optional<Heroes> heroesRepositoryById = heroesRepository.findById(id);
        if(heroesRepositoryById.isPresent())
            return ResponseEntity.ok(heroesRepositoryById.get());
        else
            return ResponseEntity.notFound().build();

    }

    @PostMapping("/heroes/create")
    public ResponseEntity<Heroes> create(@RequestBody Heroes heroes, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));

        if(heroes.getId() != null){
            log.warn("trying to create a book with id");
            System.out.println("trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Heroes result = heroesRepository.save(heroes);
        return ResponseEntity.ok(result);
    }


    @PutMapping("/heroes/update")
    public ResponseEntity<Heroes> update(@RequestBody Heroes heroes){
        if(heroes.getId() == null ){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if(!heroesRepository.existsById(heroes.getId())){
            return ResponseEntity.notFound().build();
        }

        Heroes result = heroesRepository.save(heroes);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/heroes/delete/{id}")
    public ResponseEntity<Heroes> delete(@PathVariable Long id){

        if(!heroesRepository.existsById(id)){
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }

        heroesRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/heroes/findByName")
    public List<Heroes> findByName(@RequestBody Heroes heroes){

        List<Heroes> heroesList =
                heroesService.findByNameContains(heroes.getName());

        return heroesList;
    }

}
