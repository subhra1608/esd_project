package com.example.esdproject82.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(unique = true, nullable = false)
    private String rollNumber;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(nullable = false)
    private Integer totalCredits;

    @ManyToOne
    @JoinColumn(name = "domain_id")
    private Domain domain;

    @ManyToOne
    @JoinColumn(name = "specialisation_id")
    private Specialisation specialisation;

    // Default constructor
    public Student() {}

    // Parameterized constructor
    public Student(Long studentId, String rollNumber, String firstName, String lastName, Integer totalCredits, Domain domain, Specialisation specialisation) {
        this.studentId = studentId;
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalCredits = totalCredits;
        this.domain = domain;
        this.specialisation = specialisation;
    }


}