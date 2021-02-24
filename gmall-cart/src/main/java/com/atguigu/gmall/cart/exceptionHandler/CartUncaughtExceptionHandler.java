package com.atguigu.gmall.cart.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author : SongMc
 * @date : 2021/2/24 12:47
 * className : CartUncaughtExceptionHandler
 * package: com.atguigu.gmall.cart.exceptionHandler
 * version : 1.0
 * Description
 */
@Slf4j
@Component
public class CartUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        log.error("异步任务出现异常了。方法：{}，参数：{}，异常信息：{}，",method.getName(), Arrays.asList(objects),throwable.getMessage());
    }
}
