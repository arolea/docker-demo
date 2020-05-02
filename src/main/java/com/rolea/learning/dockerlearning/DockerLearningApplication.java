package com.rolea.learning.dockerlearning;

import com.rolea.learning.dockerlearning.domain.Person;
import com.rolea.learning.dockerlearning.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerLearningApplication implements CommandLineRunner {

	@Autowired
	private PersonService personService;

	@Override
	public void run(String... args) {
		if(personService.count() == 0) {
			Person person = new Person();
			person.setName("Alex");
			personService.save(person);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerLearningApplication.class, args);
	}

}
