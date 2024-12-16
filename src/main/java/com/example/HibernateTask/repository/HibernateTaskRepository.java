package com.example.HibernateTask.repository;

import com.example.HibernateTask.model.Person;
import com.example.HibernateTask.model.PersonInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HibernateTaskRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public HibernateTaskRepository () {

    }
    public  List<Person> getPersonsByCity(String city) {
        List<PersonInfo> listPersonInfo = entityManager.createQuery("from PERSONS where city_of_living = :city",
                PersonInfo.class).setParameter("city", city).getResultList();


        return listPersonInfo.stream()
                .map(item -> item.getPerson()).collect(Collectors.toList());
    }
}
