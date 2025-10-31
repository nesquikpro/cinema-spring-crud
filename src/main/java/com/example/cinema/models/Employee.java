package com.example.cinema.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name="employ")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Поле не может быть пустым!")
    @NotNull(message = "Поле не может быть пустым!")
    @Size(min=3, max=30)
    private String firstname, lastname, thirdname, email;

    @Pattern(regexp = "7\\([0-9]{3}\\)-[0-9]{3}-[0-9]{2}-[0-9]{2}", message = "Формат: 7(999)-999-99-99")
    private String phone;


    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private Post post;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private Collection<Ticket> employee;

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getThirdname() {
        return thirdname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Collection<Ticket> getEmployee() {
        return employee;
    }

    public void setEmployee(Collection<Ticket> employee) {
        this.employee = employee;
    }

    public Employee(String firstname, String lastname, String thirdname, String email, String phone, Post post) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.thirdname = thirdname;
        this.email = email;
        this.phone = phone;
        this.post = post;
    }
}
