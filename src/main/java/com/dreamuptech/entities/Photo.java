package com.dreamuptech.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Photo extends PanacheEntity {
    public String title;
    public String author;
    public String source;
    public LocalDate date;
    public String url;

    @ManyToOne
    @JsonIgnore 
    public Person person;

}
