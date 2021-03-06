package com.example.j093.student.service;

import com.example.j093.student.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();
    public Student createNewStudent(Student student);
    public boolean deleteStudent(int id);
    public Student updateStudent(Student modifiedStudent, int id);
}
