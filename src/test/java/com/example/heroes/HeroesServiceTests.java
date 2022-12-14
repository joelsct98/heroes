package com.example.heroes;

import com.example.heroes.entities.Heroes;
import com.example.heroes.repository.HeroesRepository;
import com.example.heroes.service.HeroesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class HeroesServiceTests {

    @Mock
    HeroesRepository heroesRepository;
    @Autowired
    HeroesService heroesService;

    @Test
    void findByNameContainsNotNull() {

        // Given
        when(this.heroesRepository.findByNameContains(any())).thenReturn(mockHeroesListRequestView());

        String name = "Spiderman";

        // When
        List<Heroes> heroesList =
                heroesService.findByNameContains(name);

        // Then
        assertNotNull(heroesList);

    }

    @Test
    void findByNameContainsNameNull() {

        // Given
        when(this.heroesRepository.findByNameContains(any())).thenReturn(mockHeroesListRequestView());

        String name = null;

        // When
        List<Heroes> heroesList =
                heroesService.findByNameContains(name);

        // Then
        assertNotNull(heroesList);
        assertEquals(heroesList.size(), 0);

    }

    private List<Heroes> mockHeroesListRequestView() {

        List<Heroes> heroesList = new ArrayList<>();

        heroesList.add(heroesRequestView());

        return heroesList;
    }

    Heroes heroesRequestView() {
        Heroes heroes = new Heroes();
        heroes.setId(1L);
        heroes.setName("Spiderman");
        return heroes;
    }


}
