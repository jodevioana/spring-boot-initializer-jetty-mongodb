package org.springstarter.webmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springstarter.webmongo.model.Animal;

@Repository
public interface AnimalRepository extends MongoRepository<Animal, Object> {

    Animal findByName(String name);
    Animal findByNickname(String nickname);
    Animal findByAge(Integer age);
}
