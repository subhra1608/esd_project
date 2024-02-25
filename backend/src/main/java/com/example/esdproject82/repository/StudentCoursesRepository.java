package com.example.esdproject82.repository;

import com.example.esdproject82.model.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentCoursesRepository extends JpaRepository<StudentCourses, Long> {

    List<StudentCourses> findAllByStudent_StudentId(Long studentId);
    List<StudentCourses> findByStudent_StudentId(Long studentId);
}
