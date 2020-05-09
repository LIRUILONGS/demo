package com.liruilong.demo.controller;

import com.liruilong.model.ChatMsg;
import com.liruilong.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.logging.Logger;

/**
 * @Description :
 * @Author: Liruilong
 * @Date: 2020/2/11 14:55
 */
@RestController
public class WsController {

    Logger logger = Logger.getLogger("com.liruilong.demo.controller.WsController");

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;


  /**
   * @param authentication
   * @param chatMsg
   * @return
   * @description 点对点。这个为了演示方遍，把请求对象放request里面了。request用户获取当前的用户信息。
   *              chatMag为客户端发送来的消息。
   * @author Liruilong
   * @date  2020年05月09日  20:05:49
   **/

    // 接受消息
    @MessageMapping("/chat")
    public void handleMsg(Authentication authentication, ChatMsg chatMsg) {
        Hr hr = (Hr) authentication.getPrincipal();
        //发送点
        chatMsg.setFrom(hr.getUsername());
        //发送点名称
        chatMsg.setFromNickname(hr.getName());
        // 发送日期
        chatMsg.setDate(new Date());
        logger.info("发送的消息实体为："+chatMsg.toString());
        // 群发消息依然使用＠SendTo 注解来实现， 点对点的消息发送则使用 SimpMessagingTemplate 来实现。
        // 对消息路径做了处理默认添加/user
        simpMessagingTemplate.convertAndSendToUser(chatMsg.getTo(), "/queue/chat", chatMsg);
    }

}
