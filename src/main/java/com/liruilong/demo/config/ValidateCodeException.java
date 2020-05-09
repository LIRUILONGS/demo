package com.liruilong.demo.config;


import org.springframework.security.core.AuthenticationException;


/**
 * @Description :
 * @Author: Liruilong
 * @Date: 2020/2/8 7:24
 */

public class ValidateCodeException extends AuthenticationException  {

    public ValidateCodeException(String msg) {
        super(msg);
    }


}
