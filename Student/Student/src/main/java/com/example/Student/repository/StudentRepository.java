package com.example.Student.repository;

import com.example.Student.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Students,Integer> {
    List<Students> findByName(String name);
}
