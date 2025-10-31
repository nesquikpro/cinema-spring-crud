package com.example.cinema.repository;

import com.example.cinema.models.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaceRepository extends CrudRepository<Place, Long> {
    List<Place> findByRow(Integer row);

    Place findPlaceByRow(Integer row);
}
