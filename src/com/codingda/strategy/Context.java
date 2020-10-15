package com.codingda.strategy;

import com.codingda.commons.Status;
import com.codingda.pojo.Command;
import com.codingda.commons.Message;

public class Context {

    private Context() {
    }


    public static Message execute(Command command,Message message) throws Exception{
        switch (command) {
            case ADD:
                return new AddOperation().doOperation(message);

            case DEL:
                return new DelOperation().doOperation(message);

            case FIND:
                return new FindOperation().doOperation(message);

            case UPDATE:
                return new UpdateOperation().doOperation(message);
            case FEED:
                return new FeedOperation().doOperation(message);
            case SORT:return new SortOperation().doOperation(message);
            default:
                return Message.fail().setParams(Status.OUTPUT, "the command you input is wrong");
        }
    }
}
