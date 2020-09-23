package com.rolea.learning.dockerlearning.controller;

import com.rolea.learning.dockerlearning.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @Value("${app.name:default}")
    private String appName;

    @Value("${pod.name:none}")
    private String podName;

    @GetMapping(value = "/hello")
    public String sayHello(){
        return String.format("Hello %s from app %s and pod %s!",
                personService.findByName("Alex").getName(), appName, podName);
    }

}
