package com.example.cinema.repository;

import com.example.cinema.models.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SessionRepository extends CrudRepository<Session, Long> {

    List<Session> findByTime(String time);
    List<Session> findByTimeContaining(String time);
}
