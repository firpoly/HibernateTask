package com.example.HibernateTask.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jdk.jfr.DataAmount;

@Entity(name = "PERSONS")
@Table (name = "PERSONS")
public class PersonInfo {
    @EmbeddedId
    private Person person;
    private String phone_number;
    private String city_of_living;
    public PersonInfo(){}

    public Person getPerson() {
        return person;
    }
}
