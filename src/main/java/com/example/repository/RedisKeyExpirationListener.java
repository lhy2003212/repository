package com.example.repository;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {
    //from fhadmin.cn
    @Override
    public void onMessage(Message message, byte[] pattern) {

        String expiredKey = message.toString();
        System.out.println(expiredKey + "过期了");
        //发送短信给用户
    }

    public RedisKeyExpirationListener(RedisMessageListenerContainer redisMessageListenerContainer ){
        super(redisMessageListenerContainer);
    }
}
