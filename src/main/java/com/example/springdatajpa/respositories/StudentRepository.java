package com.example.springdatajpa.respositories;

import com.example.springdatajpa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    //Query(SELECT s FROM Student s WHERE s.email = ?1)
    Optional<Student> findStudentByEmail(String email);
}
