package com.example.cinema.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @NotNull(message = "Поле не может быть пустым!")
    @Size(min=3, max=30)
    private String name;

    @NotNull(message = "Поле не может быть пустым!")
    @Max(value = 150000)
    @Min(value = 45000)
    private Integer salary;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private Collection<Employee> employees;


    public Post() {

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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Collection<Employee> getPost() {
        return employees;
    }

    public void setPost(Collection<Employee> post) {
        this.employees = post;
    }
}
