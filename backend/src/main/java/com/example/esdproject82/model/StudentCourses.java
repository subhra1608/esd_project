package com.example.esdproject82.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
@Table(name = "student_courses")
public class StudentCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    // Default constructor
    public StudentCourses() {}

    // Constructor with parameters
    public StudentCourses(Long id, Student student, Course course) {
        this.id = id;
        this.student = student;
        this.course = course;
    }

    // Getters and Setters
}
