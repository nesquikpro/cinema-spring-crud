package com.example.cinema.repository;

import com.example.cinema.models.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Long> {
    List<Film> findByName(String name);
    List<Film> findByNameContaining(String name);

    Film findFilmByName(String name);
}
