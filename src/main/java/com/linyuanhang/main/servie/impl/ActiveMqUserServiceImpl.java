package com.linyuanhang.main.servie.impl;

import com.linyuanhang.main.pojo.User;
import com.linyuanhang.main.servie.ActiveMqUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActiveMqUserServiceImpl implements ActiveMqUserService {

    @Autowired
    private JmsTemplate jmsTemplate;

    private static final String myDestination = "my-destination";

    @Override
    public void sendMsg(User user) {
        System.out.println("发送消息："+user.toString());
        jmsTemplate.convertAndSend(myDestination,user);
    }

    @Override
    public void reciveMsg(User user) {
        System.out.println("接收到消息："+user.toString());
    }
}
