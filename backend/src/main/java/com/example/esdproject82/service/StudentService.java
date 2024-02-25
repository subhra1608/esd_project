package com.example.esdproject82.service;

import com.example.esdproject82.exception.ResourceNotFoundException;
import com.example.esdproject82.model.Student;
import com.example.esdproject82.repository.StudentRepository;
import com.example.esdproject82.repository.StudentCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentCoursesRepository studentCoursesRepository;


    public List<Student> findAllStudentsWithSpecialisation() {
        List<Student> allStudents = studentRepository.findAll();


        List<Student> studentsWithSpecialisation = allStudents.stream()
                .filter(this::hasSpecialisation)
                .collect(Collectors.toList());
        return studentsWithSpecialisation;
    }


    public List<Student> findStudentsByDomainWithSpecialisation(Long domainId) {
        return studentRepository.findAllByDomain_DomainId(domainId).stream()
                .filter(student -> hasSpecialisation(student))
                .collect(Collectors.toList());
    }

    private boolean hasSpecialisation(Student student) {
        int totalCredits = studentCoursesRepository.findAllByStudent_StudentId(student.getStudentId()).stream()
                .mapToInt(sc -> sc.getCourse().getCredits())
                .sum();

        return totalCredits > 20;
    }


    public Student findStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }


}
