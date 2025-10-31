package com.example.cinema.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @NotNull(message = "Поле не может быть пустым!")
    @Size(min=6, max=30)
    private String name;

    @Max(value = 500)
    @Min(value = 100)
    private Integer ticketprice;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Collection<Hall> halls;

    public Category() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(Integer ticketprice) {
        this.ticketprice = ticketprice;
    }

    public Collection<Hall> getCategory() {
        return halls;
    }

    public void setCategory(Collection<Hall> category) {
        this.halls = category;
    }

    public Category(String name, Integer ticketprice, Collection<Hall> category) {
        this.name = name;
        this.ticketprice = ticketprice;
        this.halls = category;
    }
}
