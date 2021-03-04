package com.atguigu.order.interceptor;

import com.atguigu.order.config.JwtProperties;
import com.atguigu.order.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : SongMc
 * @date : 2021/2/23 20:18
 * className : LoginInterceptor
 * package: com.atguigu.gmall.cart.interceptor
 * version : 1.0
 * Description
 */
@Component
@EnableConfigurationProperties(JwtProperties.class)
public class LoginInterceptor implements HandlerInterceptor {

    private static final ThreadLocal<UserInfo> THREAD_LOCAL = new ThreadLocal<>();

    @Autowired
    private JwtProperties properties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        UserInfo userInfo = new UserInfo();


        // 获取token
        String userId = request.getHeader("userId");
        userInfo.setUserId(Long.valueOf(userId));

        THREAD_LOCAL.set(userInfo);

        return true;
    }

    public static UserInfo getUserInfo(){
        return THREAD_LOCAL.get();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 这里必须清空threadLocal中的资源，因为使用的是tomcat线程池，线程无法结束
        THREAD_LOCAL.remove();
    }
}
