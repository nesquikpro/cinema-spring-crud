package com.example.cinema.repository;

import com.example.cinema.models.Hall;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HallRepository extends CrudRepository<Hall, Long> {
    List<Hall> findByName(String name);
    List<Hall> findByNameContaining(String name);

    Hall findHallByName(String name);
}
