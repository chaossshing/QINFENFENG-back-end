package com.codingda.strategy;

import com.codingda.commons.Message;
import com.codingda.commons.Status;
import com.codingda.pojo.Animal;
import com.codingda.pojo.Dog;
import com.codingda.pojo.Zoo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortOperation implements Operation {
    @Override
    public Message doOperation(Message message) throws Exception {
        Zoo zoo = Zoo.getInstance();
        List<Animal> animals = zoo.getAnimals();
        List<Dog> dogs = animals.stream()
                .map(a -> (Dog) a)
                .collect(Collectors.toList());
        Collections.sort(dogs);
        dogs.forEach(dog -> System.out.println(dog.toString()));
        return Message.success().setParams(Status.OUTPUT, "");
    }
}
