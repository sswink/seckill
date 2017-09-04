package com.seckill.exception;

/**
 * Created by ziheng on 2017/8/23.
 */
public class RepeatkillException extends SeckillException {
    public RepeatkillException(String message) {
        super(message);
    }

    public RepeatkillException(String message, Throwable cause) {
        super(message, cause);
    }
}
