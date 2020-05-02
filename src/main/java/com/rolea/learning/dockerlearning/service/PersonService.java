package com.rolea.learning.dockerlearning.service;

import com.rolea.learning.dockerlearning.domain.Person;

public interface PersonService {

    Person save(Person person);

    Person findByName(String name);

    long count();

}
