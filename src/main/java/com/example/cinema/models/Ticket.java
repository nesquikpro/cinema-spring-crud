package com.example.cinema.models;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private Place place;
    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private Cinema cinema;
    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private Employee employee;
    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private Hall hall;

    public Ticket() {

    }


    public Ticket(Cinema cinema, Hall hall, Place place, Employee employee) {

        this.cinema = cinema;
        this.hall = hall;
        this.place = place;
        this.employee = employee;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
