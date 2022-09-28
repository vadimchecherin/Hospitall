package com.example.Web_BD.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient_reception {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String Date_of_visit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate_of_visit() {
        return Date_of_visit;
    }

    public void setDate_of_visit(String date_of_visit) {
        Date_of_visit = date_of_visit;
    }

    public String getDiagnos() {
        return Diagnos;
    }

    public void setDiagnos(String diagnos) {
        Diagnos = diagnos;
    }

    private String Diagnos;

}
