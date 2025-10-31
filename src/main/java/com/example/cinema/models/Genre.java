package com.example.cinema.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @NotNull(message = "Поле не может быть пустым!")
    @Size(min=3, max=30)
    private String name;

    @OneToMany(mappedBy = "genre", fetch = FetchType.EAGER)
    private Collection<Film> films;

    public Genre() {

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

    public Collection<Film> getGenre() {
        return films;
    }

    public void setGenre(Collection<Film> genre) {
        this.films = genre;
    }

}
