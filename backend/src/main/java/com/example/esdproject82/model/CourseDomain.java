package com.example.esdproject82.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course_domain")
@Getter @Setter
public class CourseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    @ManyToOne
    @JoinColumn(name = "domain_id")
    private Domain domain;

    // Default Constructor
    public CourseDomain() {
    }

    // Parameterized Constructor
    public CourseDomain(Course course, Domain domain) {
        this.course = course;
        this.domain = domain;
    }
}
