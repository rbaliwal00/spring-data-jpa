package com.example.springdatajpa.bootstrap;

import com.example.springdatajpa.domain.Student;
import com.example.springdatajpa.respositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    StudentRepository studentRepository;

    public DataLoader(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Student maria = new Student(
                "Maria",
                "Jones",
                "abc@gmail.com",
                24
        );

        Student adam = new Student(
                "Adam",
                "Sandler",
                "adamsandler@gmail.com",
                30
        );

        studentRepository.save(maria);
        studentRepository.save(adam);
    }
}
