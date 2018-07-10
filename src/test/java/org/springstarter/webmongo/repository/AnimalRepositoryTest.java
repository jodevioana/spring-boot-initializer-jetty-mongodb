package org.springstarter.webmongo.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springstarter.webmongo.model.Animal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
public class AnimalRepositoryTest {

    @Autowired
    AnimalRepository animalRepository;

    private static Animal TEST_ANIMAL = new Animal("Testing Animal", "Testing Nickname", 1);

    @Before
    public void setUp() {

       animalRepository.save(TEST_ANIMAL);
    }

    @Test
    public void testFindAnimalByName() {
        Animal animal = animalRepository.findByName(TEST_ANIMAL.getName());
        assertEquals(TEST_ANIMAL, animal);
    }
}
