package com.dreamuptech.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class Person extends PanacheEntity {    
    public String name; 
    public LocalDate birth;
    public String place;
    public String profile;
   
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER) 
    @JsonIgnore
    public List<Photo> photos;
    
    @Transient
    @JsonGetter
    public int age(){
        if(birth == null) return 0;
        return Period.between(birth, LocalDate.now()).getYears();        
    }

    public static Person findByName(String name){        
        return find("name", name).firstResult();
    }   
}
