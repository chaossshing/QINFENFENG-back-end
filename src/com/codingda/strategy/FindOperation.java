package com.codingda.strategy;

import com.codingda.commons.Status;
import com.codingda.commons.Message;
import com.codingda.pojo.Zoo;

public class FindOperation implements Operation {
    @Override
    public Message doOperation(Message message) throws Exception{
        return Message.success().setParams(Status.OUTPUT, Zoo.getInstance().getAnimals());
    }
}
