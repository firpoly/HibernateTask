package com.example.HibernateTask.service;

import com.example.HibernateTask.model.Person;
import com.example.HibernateTask.repository.HibernateTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HibernateTaskService {
    private final HibernateTaskRepository repository;

    public HibernateTaskService(HibernateTaskRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }

}
