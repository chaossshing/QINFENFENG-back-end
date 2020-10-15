package com.codingda.commons;

import java.util.HashMap;
import java.util.Map;

public class Message {
    private Status status;
    private Map<Status, Object> params =new HashMap<Status, Object>();
    private Message(){

    }

    public static Message success(){
        Message message = new Message();
        message.setStatus(Status.SUCCESS);
        return message;
    }
    public static  Message fail(){
        Message message = new Message();
        message.setStatus(Status.FAIL);
        return message;
    }
    public  Message setParams(Status key,Object value){
        this.params.put(key,value);
        return this;
    }

    public Map<Status, Object> getParams() {
        return params;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
