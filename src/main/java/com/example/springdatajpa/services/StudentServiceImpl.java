package com.example.springdatajpa.services;

import com.example.springdatajpa.domain.Student;
import com.example.springdatajpa.respositories.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("email already taken!");
        }

        studentRepository.save(student);

    }

    @Override
    public void deleteStudent(Long studentId) {
        boolean exits = studentRepository.existsById(studentId);

        if(!exits){
            throw new IllegalStateException("student with id: " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id: " + studentId + " does not exists."));

        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getFirstName(), name)){
            student.setFirstName(name);
        }

        if(email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken!!!!");
            }
            student.setEmail(email);
        }
    }
}
