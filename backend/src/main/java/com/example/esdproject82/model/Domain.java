package com.example.esdproject82.model;

import jakarta.persistence.*;

@Entity
@Table(name = "domain")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long domainId;

    @Column(nullable = false)
    private String program;

    // Default constructor (required by JPA)
    public Domain() {
    }

    // Constructor with all parameters
    public Domain(Long domainId, String program) {
        this.domainId = domainId;
        this.program = program;
    }

    // Getters
    public Long getDomainId() {
        return domainId;
    }

    public String getProgram() {
        return program;
    }

    // Setters
    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    // toString (optional, can be helpful for debugging)
    @Override
    public String toString() {
        return "Domain{" +
                "domainId=" + domainId +
                ", program='" + program + '\'' +
                '}';
    }
}
