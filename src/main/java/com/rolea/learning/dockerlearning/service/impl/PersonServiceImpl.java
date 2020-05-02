package com.rolea.learning.dockerlearning.service.impl;

import com.rolea.learning.dockerlearning.domain.Person;
import com.rolea.learning.dockerlearning.repository.PersonRepository;
import com.rolea.learning.dockerlearning.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person findByName(String name) {
        return personRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

    @Override
    public long count() {
        return personRepository.count();
    }

}
