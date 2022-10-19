package com.shopx.oauth.service;


import com.shopx.oauth.util.AuthToken;

/*
 *
 */
public interface AuthService {

    /***
     * 授权认证方法
     */
    AuthToken login(String username, String password, String clientId, String clientSecret,String grandType);
}
