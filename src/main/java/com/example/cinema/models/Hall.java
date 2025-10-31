package com.example.cinema.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
@Table(name="hall")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @NotNull(message = "Поле не может быть пустым!")
    @Size(min=3, max=30)
    private String name;

    @Max(value = 100)
    @Min(value = 30)
    private Integer capacity;

    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private Category category;

    @OneToMany(mappedBy = "hall", fetch = FetchType.EAGER)
    private Collection<Ticket> tickets;


    public Hall(String name, Integer capacity, Category category) {
        this.name = name;
        this.capacity = capacity;
        this.category = category;
        this.tickets = tickets;
    }

    public Hall() {

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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<Ticket> getHall() {
        return tickets;
    }

    public void setHall(Collection<Ticket> hall) {
        this.tickets = hall;
    }
}
