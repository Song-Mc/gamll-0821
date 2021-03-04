package com.atguigu.gmall.common.exception;

/**
 * @author : SongMc
 * @date : 2021/2/27 20:59
 * className : OrderException
 * package: com.atguigu.gmall.common.exception
 * version : 1.0
 * Description
 */
public class OrderException extends RuntimeException {

    public OrderException() {
        super();
    }

    public OrderException(String message) {
        super(message);
    }
}
