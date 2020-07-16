package com.rolea.learning.dockerlearning.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@RestController
public class PersonController {

    @Value("${secret.key}")
    private String secretValue;

    @GetMapping(value = "/hello")
    public String sayHello() throws UnknownHostException {
        return String.format("Hello from %s! Secret value: %s", Inet4Address.getLocalHost().getHostAddress(), secretValue);
    }

}
