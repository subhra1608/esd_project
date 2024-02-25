package com.example.esdproject82.repository;

import com.example.esdproject82.model.Student;
import com.example.esdproject82.model.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByDomain_DomainId(Long domainId);




}
