package org.springstarter.webmongo.service;

import org.springstarter.webmongo.model.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> findAllAnimals();

    void saveOrUpdate(Animal animal);

    Animal findByName(String name);

    Animal findByNickname(String nickname);

    Animal findByAge(Integer age);

    long animalCount();

    boolean exists(String id);

    void delete(Animal animal);

    void deleteAll();
}
