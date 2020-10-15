package com.codingda.strategy;

import com.codingda.commons.Message;
import com.codingda.commons.Status;
import com.codingda.pojo.Animal;
import com.codingda.pojo.Dog;
import com.codingda.pojo.Zoo;

import java.util.List;

public class FeedOperation implements Operation {
    @Override
    public Message doOperation(Message message) throws Exception {
        String[] params = (String[]) message.getParams().get(Status.INPUT);
        Zoo zoo = Zoo.getInstance();
        List<Animal> animals = zoo.getAnimals();
        if (params.length > 1) {
            String name = params[1];
            animals.forEach(animal -> {
                Dog dog = (Dog) animal;
                if (dog.getName().equals(name)) {
                    dog.feed();
                }
            });
        } else {
            animals.forEach(Animal::feed);
        }


        return Message.success().setParams(Status.OUTPUT, "");
    }
}
