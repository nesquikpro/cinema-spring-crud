package com.example.cinema.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @NotNull(message = "Поле не может быть пустым!")
    @Size(min=3, max=30)
    private String name, address;

    @Pattern(regexp = "7\\([0-9]{3}\\)-[0-9]{3}-[0-9]{2}-[0-9]{2}", message = "Формат: 7(999)-999-99-99")
    private String phone;

    @OneToMany(mappedBy = "cinema", fetch = FetchType.EAGER)
    private Collection<Ticket> cinema;

    public Cinema() {

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<Ticket> getCinema() {
        return cinema;
    }

    public void setCinema(Collection<Ticket> cinema) {
        this.cinema = cinema;
    }

    public Cinema(String name, String address, String phone, Collection<Ticket> cinema) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.cinema = cinema;
    }
}
