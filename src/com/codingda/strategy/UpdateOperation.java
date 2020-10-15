package com.codingda.strategy;

import com.codingda.commons.Status;
import com.codingda.commons.Message;
import com.codingda.pojo.Animal;
import com.codingda.pojo.Dog;
import com.codingda.pojo.Zoo;

import java.util.List;

public class UpdateOperation implements Operation {
    @Override
    public Message doOperation(Message message) throws Exception{
        String[] params = (String[])message.getParams().get(Status.INPUT);
        String name = params[1];
        int age = Integer.parseInt(params[2]);
        String sex = params[3];
        Zoo zoo = Zoo.getInstance();
        List<Animal> animals = zoo.getAnimals();
        animals.forEach((a)->{
            Dog dog = (Dog)a;
            if (dog.getName().equals(name)){
                dog.setAge(age);
                dog.setSex(sex);
            }
        });
        zoo.setAnimals(animals);
        return Message.success().setParams(Status.OUTPUT, "UPDATE SUCCESS");
    }

}
