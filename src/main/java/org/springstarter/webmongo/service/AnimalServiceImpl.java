package org.springstarter.webmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springstarter.webmongo.model.Animal;
import org.springstarter.webmongo.repository.AnimalRepository;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public List<Animal> findAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public void saveOrUpdate(Animal animal) {
        //if an animal with the same id exists -> update
        animalRepository.save(animal);
    }

    @Override
    public Animal findByName(String name) {
        return animalRepository.findByName(name);
    }

    @Override
    public Animal findByNickname(String nickname) {
        return animalRepository.findByNickname(nickname);
    }

    @Override
    public Animal findByAge(Integer age) {
        return animalRepository.findByAge(age);
    }

    @Override
    public long animalCount() {
        return animalRepository.count();
    }

    @Override
    public boolean exists(String id) {
        return animalRepository.existsById(id);
    }

    @Override
    public void delete(Animal animal) {
        animalRepository.delete(animal);
    }

    @Override
    public void deleteAll() {
        animalRepository.deleteAll();
    }
}
