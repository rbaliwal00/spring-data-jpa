package com.example.springdatajpa.services;

import com.example.springdatajpa.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    public List<Student> getStudents();

    void addNewStudent(Student student);

    void deleteStudent(Long studentId);

    void updateStudent(Long studentId, String name, String email);
}
