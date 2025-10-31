package com.example.cinema.repository;

import com.example.cinema.models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByEmail(String email);

    List<Employee> findByLastname(String lastname);
    List<Employee> findByLastnameContaining(String lastname);

    Employee findEmployeeByLastname(String lastname);
}
