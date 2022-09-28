package com.example.Web_BD.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String FIO;
    private String Speciality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }

    public Personal() {
    }

    public Personal(String FIO, String speciality) {
        this.FIO = FIO;
        Speciality = speciality;
    }
}
