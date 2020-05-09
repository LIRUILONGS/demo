package com.liruilong.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Description : 自定义类 WebSocketConfig 继承自 WebSocketMessageBrokerConfigurer 进行 WebSocket 配置
 * 通过@EnableWebSocketMessageBroker注解开启 WebSocket 消息代理
 * @Author: Liruilong
 * @Date: 2020/2/11 14:45
 */
@Configuration
// 开启WebSocket消息代理
@EnableWebSocketMessageBroker
public class WebSocketConfig  implements WebSocketMessageBrokerConfigurer {


    /**
    * @Author Liruilong
    * @Description   建立链接
    * @Date 14:50 2020/2/11
    * @Param [registry]
    * @return void
    **/

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
       //定义一个前缀为“/ws/ep”的 endPoint，并开启 sockjs 支持，
        registry.addEndpoint("/ws/ep").setAllowedOrigins("*").withSockJS();

    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /*
        消息代理的前缀，即如果消息代理的前缀为指定的字符，就会将消息转发给消息代理broker
        在由消息代理将消息广播给当前的连接的客户端。
        */
        registry.enableSimpleBroker("/queue");
        /*
       前缀为“/app”的 destination 可以通过＠MessageMapping 注解的方法处理，
       而其他 destination （例如“/topic”“/queue”）将被直接交给 broker 处理。
        */
        registry.setApplicationDestinationPrefixes("/ws");
    }
}
