package com.example.cinema.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Поле не может быть пустым!")
    @Max(value = 13)
    @Min(value = 1)
    private Integer row, seat;

    @OneToMany(mappedBy = "place", fetch = FetchType.EAGER)
    private Collection<Ticket> place;

    public Place() {

    }

    public Place(Integer row, Integer seat, Collection<Ticket> place) {
        this.row = row;
        this.seat = seat;
        this.place = place;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Collection<Ticket> getPlace() {
        return place;
    }

    public void setPlace(Collection<Ticket> place) {
        this.place = place;
    }
}
