package com.linyuanhang.main.servie;

public interface ActiveMqService {
    //发送消息
    public void sendMsg(String message);
    //接收消息
    public void reciveMsg(String message);
}
