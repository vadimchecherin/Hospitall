package com.example.Web_BD.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String FIO;
    private String Sex;
    private String Date_of_Birthday;
    private String Date_of_Reg;
    private String passport;



    public Post(String FIO, String sex, String date_of_Birthday, String date_of_Reg, String passport) {
        this.FIO = FIO;
        Sex = sex;
        Date_of_Birthday = date_of_Birthday;
        Date_of_Reg = date_of_Reg;
        this.passport = passport;
    }



    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

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

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getDate_of_Birthday() {
        return Date_of_Birthday;
    }

    public void setDate_of_Birthday(String date_of_Birthday) {
        Date_of_Birthday = date_of_Birthday;
    }

    public String getDate_of_Reg() {
        return Date_of_Reg;
    }

    public void setDate_of_Reg(String date_of_Reg) {
        Date_of_Reg = date_of_Reg;
    }

    public Post() {
    }


}
