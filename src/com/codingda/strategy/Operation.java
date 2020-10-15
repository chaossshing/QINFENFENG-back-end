package com.codingda.strategy;

import com.codingda.commons.Message;

public interface Operation {
    Message doOperation(Message message) throws Exception;
}
