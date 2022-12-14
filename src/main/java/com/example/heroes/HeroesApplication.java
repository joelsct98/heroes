package com.example.heroes;

import com.example.heroes.entities.Heroes;
import com.example.heroes.repository.HeroesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HeroesApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(HeroesApplication.class, args);

        HeroesRepository repository = context.getBean(HeroesRepository.class);

        System.out.println("numero coches sin registros: " + repository.count());

        Heroes spiderman = new Heroes(1L, "Spiderman");
        repository.save(spiderman);
        Heroes superman = new Heroes(2L, "Superman");
        repository.save(superman);
        Heroes ironMan = new Heroes(3L, "IronMan");
        repository.save(ironMan);
        Heroes guts = new Heroes(4L, "Guts");
        repository.save(guts);

        // recuperar todos
        System.out.println(repository.findAll());
    }

}
