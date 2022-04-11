package com.example.j093.student.service.impl;

import com.example.j093.student.model.Student;
import com.example.j093.student.repository.StudentRepository;
import com.example.j093.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().forEach(studentList::add);
        return studentList;
    }
}
