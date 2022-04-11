package com.example.j093.student.controller;

import com.example.j093.student.model.Student;
import com.example.j093.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }
}
