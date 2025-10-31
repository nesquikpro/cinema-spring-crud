package com.example.cinema.repository;

import com.example.cinema.models.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
    List<Ticket> findByCinemaName(String name);
    List<Ticket> findByCinemaNameContaining(String name);

    List<Ticket> findById(String id);
}
