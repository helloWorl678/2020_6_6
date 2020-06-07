package com.linyuanhang.main.servie;

import com.linyuanhang.main.pojo.User;

public interface ActiveMqUserService {
    //发送消息
    public void sendMsg(User user);
    //接收消息
    public void reciveMsg(User user);
}
