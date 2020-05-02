package com.rolea.learning.dockerlearning.controller;

import com.rolea.learning.dockerlearning.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/hello")
    public String sayHello(){
        return String.format("Hello %s!", personService.findByName("Alex").getName());
    }

}
