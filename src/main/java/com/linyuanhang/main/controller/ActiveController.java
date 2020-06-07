package com.linyuanhang.main.controller;

import com.linyuanhang.main.pojo.User;
import com.linyuanhang.main.servie.ActiveMqService;
import com.linyuanhang.main.servie.ActiveMqUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/activemq")
public class ActiveController {
//    注入服务对象
    @Autowired
    private ActiveMqService activeMqService=null;
//    注入服务对象
    @Autowired
    private ActiveMqUserService activeMqUserService=null;
//    测试普通消息的发送
    @ResponseBody
    @GetMapping("/msg")
    public Map<String,Object> msg(String msg){
        activeMqService.sendMsg(msg);
        return result(true,msg);
    }
//    测试user对象的发送
    @ResponseBody
    @GetMapping("/user")
    public Map<String,Object> sendUser(Long id,String userName,String note){
        User user=new User(id,userName,note);
        activeMqUserService.sendMsg(user);
        return result(true,user);
    }

    private Map<String,Object> result(Boolean success,Object msg){
        Map<String,Object> result=new HashMap<>();
        result.put("success",success);
        result.put("message",msg);
        return  result;
    }
}


