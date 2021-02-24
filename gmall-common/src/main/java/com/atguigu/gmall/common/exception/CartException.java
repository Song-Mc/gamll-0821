package com.atguigu.gmall.common.exception;

/**
 * @author : SongMc
 * @date : 2021/2/23 23:45
 * className : CartException
 * package: com.atguigu.gmall.common.exception
 * version : 1.0
 * Description
 */
public class CartException extends RuntimeException {

    public CartException() {
        super();
    }

    public CartException(String message) {
        super(message);
    }
}
