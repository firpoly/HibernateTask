package com.example.HibernateTask.service;

import com.example.HibernateTask.model.Person;
import com.example.HibernateTask.model.PersonInfo;
import com.example.HibernateTask.repository.HibernateTaskIntrefaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HibernateTaskService {
    @Autowired
    private final HibernateTaskIntrefaceRepository repository;

    public HibernateTaskService(HibernateTaskIntrefaceRepository repository) {

        this.repository = repository;
    }

    public List<PersonInfo> getPersonsByCity(String city) {

        return repository.findByCityofliving(city);
    }

    public List<PersonInfo> getGetConsumerByAge(int age) {
        return repository.findByAge(age);
    }

    public List<PersonInfo> getPersonsByFI(String name, String surname) {
        return repository.findByNameAndSurname(name, surname);
    }

    public String setPerson(String name, String surname, int age) {
        if (repository.findByNameAndSurname(name, surname).size() == 0) {
            Person person = new Person(name, surname, age);
            return repository.setPerson(person) == 1 ? "ok" : "not ok";
        }
        return "record is already exist";

    }

}
