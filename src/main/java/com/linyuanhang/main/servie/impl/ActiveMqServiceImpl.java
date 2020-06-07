package com.linyuanhang.main.servie.impl;

import com.linyuanhang.main.servie.ActiveMqService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ActiveMqServiceImpl implements ActiveMqService {

    @Override
    public void sendMsg(String message) {
        System.out.println("发送消息："+message);
    }

    @Override
    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void reciveMsg(String message) {
        System.out.println("接收消息："+message);
    }
}
