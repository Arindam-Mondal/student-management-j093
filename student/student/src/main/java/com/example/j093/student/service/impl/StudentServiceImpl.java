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
        //to return only the students whose firstName starts with letter A
        //studentRepository.findAll() -> bring me all the students from the database
//        studentRepository.findAll().forEach(student -> {
//            if (student.getFirstName().charAt(0) == 'A' || student.getFirstName().charAt(0) == 'a') {
//                studentList.add(student);
//            }
//        });

        studentRepository.findAll().forEach(studentList::add);
        return studentList;
    }

    @Override
    public Student createNewStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentRepository.findById(id).map(student -> {
            studentRepository.deleteById(student.getId());
            return true;
        }).orElseGet(()->{return false;});
    }

    @Override
    public Student updateStudent(Student modifiedStudent, int id) {
        return studentRepository.findById(id).map(student -> {
            student.setFirstName(modifiedStudent.getFirstName());
            student.setLastName(modifiedStudent.getLastName());
            return studentRepository.save(student);
        }).orElseGet(()->{return null;});
    }
}
