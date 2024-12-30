package com.example.HibernateTask.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity(name = "PERSONS")
@Table(name = "PERSONS")

public class PersonInfo {
    @EmbeddedId
    private Person person;
    private String phone_number;
    @Column(name = "city_of_living")
    private String cityOfLiving;

    public PersonInfo() {
    }

    public Person getPerson() {
        return person;
    }
}
