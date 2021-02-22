package com.atguigu.gmall.index.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : SongMc
 * @date : 2021/2/18 15:34
 * className : RedissonConfig
 * package: com.atguigu.gmall.index.config
 * version : 1.0
 * Description
 */
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.184.128:6379");
        return Redisson.create(config);
    }

}
