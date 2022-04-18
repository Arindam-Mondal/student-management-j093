package com.example.j093.student.controller;

import com.example.j093.student.model.Student;
import com.example.j093.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }

    @PostMapping(value="/students")
    public ResponseEntity<Student> createNewStudent(@RequestBody Student newStudent) {
        return new ResponseEntity<>(studentService.createNewStudent(newStudent), HttpStatus.OK);
    }

    @PutMapping(value="/students/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable int id, @RequestBody Student modifiedStudent) {
        Student student = studentService.updateStudent(modifiedStudent,id);
        return student == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(student,HttpStatus.OK);
    }

    @DeleteMapping(value="/students/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable int id) {
        Boolean isDeleted = studentService.deleteStudent(id);
        return !isDeleted ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
    }
}
