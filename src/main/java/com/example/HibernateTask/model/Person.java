package com.example.HibernateTask.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class Person  implements Serializable {
    private String name;
    private String surname;
    private int age;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }
}
