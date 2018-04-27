package com.zy.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zy.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MqListener {

    private static final Logger logger = LoggerFactory.getLogger(MqListener.class);

    @JmsListener(destination = "user")
    public void receiveMessage(String mqMessage){
        logger.info("----------接收到mq的消息：【{}】-----------",mqMessage);
        User user = JSON.parseObject(mqMessage, new TypeReference<User>(){});
        logger.info("----------接收到mq的消息的用户名：【{}】-----------",user.getUserName());
    }
}
