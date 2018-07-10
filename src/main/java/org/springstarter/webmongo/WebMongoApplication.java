package org.springstarter.webmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springstarter.webmongo.model.Animal;
import org.springstarter.webmongo.repository.AnimalRepository;
import org.springstarter.webmongo.service.AnimalService;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan //current package
@EnableMongoRepositories
public class WebMongoApplication implements CommandLineRunner {

	@Value("${de.mindsmedical.randomvalue}")
	private String randomValue;

	@Autowired
	private AnimalService animalService;

	public static void main(String[] args) {
		SpringApplication.run(WebMongoApplication.class, args);
	}

	@Override
	public void run(String... args) {

		animalService.deleteAll();

		animalService.saveOrUpdate(new Animal("Dog", "Good boy", 5));
		animalService.saveOrUpdate(new Animal("Cat", "Kitty", 9));
		animalService.saveOrUpdate(new Animal("Horse", "Unicorn", 6));

		System.out.println("---------------- Random value from property file - " + randomValue);
	}
}
