package com.example.esdproject82.controller;

import com.example.esdproject82.model.Student;
import com.example.esdproject82.repository.StudentRepository;
import com.example.esdproject82.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("/specializations")
    public ResponseEntity<List<Student>> getAllStudentsWithSpecialisation() {
        List<Student> students = studentService.findAllStudentsWithSpecialisation();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }


    @GetMapping("/specializations/domain/{domainId}")
    public ResponseEntity<List<Student>> getStudentsByDomainWithSpecialisation(@PathVariable Long domainId) {
        List<Student> students = studentService.findStudentsByDomainWithSpecialisation(domainId);
        return ResponseEntity.ok(students);
    }


}
