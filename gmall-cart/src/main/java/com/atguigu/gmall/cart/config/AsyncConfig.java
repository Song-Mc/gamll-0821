package com.atguigu.gmall.cart.config;

import com.atguigu.gmall.cart.exceptionHandler.CartUncaughtExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.util.concurrent.Executor;

/**
 * @author : SongMc
 * @date : 2021/2/24 12:52
 * className : AsyncConfig
 * package: com.atguigu.gmall.cart.config
 * version : 1.0
 * Description
 */
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    @Autowired
    private CartUncaughtExceptionHandler exceptionHandler;

    /**
     * 配置线程池，约束线程数
     * @return java.util.concurrent.Executor
     */
    @Override
    public Executor getAsyncExecutor() {
        return null;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return exceptionHandler;
    }
}
