package com.example.heroes.service;

import com.example.heroes.entities.Heroes;
import com.example.heroes.repository.HeroesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroesService {

    @Autowired
    HeroesRepository heroesRepository;

    public List<Heroes> findByNameContains(String name){

        List<Heroes> heroesList =
                heroesRepository.findByNameContains(name);

        return heroesList;
    }


}
