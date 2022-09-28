package com.example.Web_BD.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Therpy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lecarst, price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLecarst() {
        return lecarst;
    }

    public void setLecarst(String lecarst) {
        this.lecarst = lecarst;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Therpy() {
    }

    public Therpy(String lecarst, String price) {
        this.lecarst = lecarst;
        this.price = price;
    }
}
