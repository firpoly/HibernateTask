package com.example.HibernateTask.controller;

import com.example.HibernateTask.model.Person;
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
        public List<Person> getGetConsumer(@RequestParam("city") String city) {
            return service.getPersonsByCity(city);
        }
}
