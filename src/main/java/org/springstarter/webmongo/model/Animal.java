package org.springstarter.webmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Animal {

    @Id public String id;
    private String name;
    private String nickname;
    private Integer age;

    public Animal(String name, String nickname, Integer age) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id) &&
                Objects.equals(name, animal.name) &&
                Objects.equals(nickname, animal.nickname) &&
                Objects.equals(age, animal.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, nickname, age);
    }
}
