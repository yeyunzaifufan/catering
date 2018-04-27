package com.zy.mq;

import com.alibaba.fastjson.JSON;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Session;

public class Message implements MessageCreator {

    private Object object;

    public Message(Object object){
        this.object = object;
    }

    @Override
    public javax.jms.Message createMessage(Session session) throws JMSException {
        return session.createTextMessage(JSON.toJSONString(object));
    }
}
