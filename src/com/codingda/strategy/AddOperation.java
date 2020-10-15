package com.codingda.strategy;

import com.codingda.commons.Status;
import com.codingda.commons.Message;
import com.codingda.pojo.Dog;
import com.codingda.pojo.Zoo;

public class AddOperation implements Operation {
    @Override
    public Message doOperation(Message message) throws Exception{
        String[] params = (String[]) message.getParams().get(Status.INPUT);
        Dog dog = new Dog(params[1],Integer.parseInt(params[2]),params[3]);
        Zoo.getInstance().getAnimals().add(dog);
        return Message.success().setParams(Status.OUTPUT, "ADD SUCCESS");
    }
}
