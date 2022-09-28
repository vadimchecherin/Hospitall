package com.example.Web_BD.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name_speciality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_speciality() {
        return name_speciality;
    }

    public void setName_speciality(String name_speciality) {
        this.name_speciality = name_speciality;
    }
}
