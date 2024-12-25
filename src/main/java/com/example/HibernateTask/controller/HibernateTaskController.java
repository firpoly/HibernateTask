package com.example.HibernateTask.controller;

import com.example.HibernateTask.model.Person;
import com.example.HibernateTask.model.PersonInfo;
import com.example.HibernateTask.service.HibernateTaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class HibernateTaskController {

    private final HibernateTaskService service;

    public HibernateTaskController(HibernateTaskService service) {
        this.service = service;
    }

    @GetMapping("/by-city")
    public List<PersonInfo> getGetConsumer(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/by-age")
    public List<PersonInfo> getGetConsumerByAge(@RequestParam("age") int age) {
        return service.getGetConsumerByAge(age);
    }

    @GetMapping("/by-fi")
    public List<PersonInfo> getPersonsByFI(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return service.getPersonsByFI(name, surname);
    }

    @GetMapping("/setPerson")
    public String setPerson(@RequestParam("name") String name, @RequestParam("surname") String surname,
                            @RequestParam("age") int age) {
        return service.setPerson(name, surname, age);
    }
}
