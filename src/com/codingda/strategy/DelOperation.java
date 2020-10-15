package com.codingda.strategy;

import com.codingda.commons.Status;
import com.codingda.commons.Message;
import com.codingda.pojo.Animal;
import com.codingda.pojo.Dog;
import com.codingda.pojo.Zoo;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DelOperation implements Operation {
    @Override
    public Message doOperation(Message message) throws Exception {
        String[] params = (String[]) message.getParams().get(Status.INPUT);
        String name = params[1];
        Zoo zoo = Zoo.getInstance();
        List<Animal> animals = zoo.getAnimals();
        Iterator<Animal> animalIterator = animals.iterator();
        while (animalIterator.hasNext()) {
            Dog dog = (Dog) animalIterator.next();
            if (dog.getName().equals(name)) {
                animalIterator.remove();
            }
        }
        Iterable<Animal> stringIterable = () -> animalIterator;
        List<Animal> animalList = StreamSupport.stream(stringIterable.spliterator(), false).collect(Collectors.toList());
        zoo.setAnimals(animalList);
        return Message.success().setParams(Status.OUTPUT, "DELETE SUCCESS");
    }
}
