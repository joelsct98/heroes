package com.example.heroes.repository;

import com.example.heroes.entities.Heroes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroesRepository extends JpaRepository<Heroes, Long> {

    List<Heroes> findByNameContains(String name);

}
