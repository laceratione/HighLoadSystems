package com.example.spring.springbootsimple;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class Counter {
    private int count = 0;

    public Counter(){
        RedisClient redisClient = RedisClient.create(RedisURI.create("redis://localhost:6379"));
        StatefulRedisConnection<String, String> redisConnection = redisClient.connect();
        RedisCommands<String, String> redisCommands = redisConnection.sync();
        inc(redisCommands);
        redisConnection.close();
        redisClient.shutdown();
    }

    public int getCount() {
        return count;
    }

    private void inc(RedisCommands<String, String> redisCommands){
        if (redisCommands.exists("counter").intValue() == 0){
            redisCommands.set("counter", "0");
        }
        else {
            Long counterLong = redisCommands.incr("counter");
            count = counterLong.intValue();
        }
    }

}
