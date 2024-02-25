package com.example.esdproject82.repository;

import com.example.esdproject82.model.SpecialisationCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialisationCourseRepository extends JpaRepository<SpecialisationCourse, Long> {


    List<SpecialisationCourse> findByCourse_CourseId(Long courseId);

}
