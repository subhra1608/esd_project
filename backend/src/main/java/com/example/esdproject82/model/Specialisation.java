package com.example.esdproject82.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "specialisation")
@Getter
@Setter
public class Specialisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specialisationId;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    // Default Constructor
    public Specialisation() {}

    // Parameterized Constructor
    public Specialisation(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Lombok will generate getters and setters
}