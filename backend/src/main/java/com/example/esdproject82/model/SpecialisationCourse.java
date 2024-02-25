package com.example.esdproject82.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "specialisation_course")
@Getter @Setter
@NoArgsConstructor  // Lombok annotation for no-args constructor
@AllArgsConstructor // Lombok annotation for all-args constructor
public class SpecialisationCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "specialisation_id")
    private Specialisation specialisation;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    // Lombok will generate the getters and setters automatically
}
