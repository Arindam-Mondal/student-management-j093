package com.example.j093.student.repository;

import com.example.j093.student.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {
}
