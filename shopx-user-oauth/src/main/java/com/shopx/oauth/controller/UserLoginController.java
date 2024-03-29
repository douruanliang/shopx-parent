package com.shopx.oauth.controller;

import com.shopx.oauth.service.AuthService;
import com.shopx.oauth.util.AuthToken;
import com.shopx.oauth.util.CookieUtil;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 描述
 * 密码认证控制类
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private AuthService loginService;

    @Value("${auth.clientId}")
    private String clientId;

    @Value("${auth.clientSecret}")
    private String clientSecret;

    private static final String GRAND_TYPE = "password";//授权模式 密码模式


    @Value("${auth.cookieDomain}")
    private String cookieDomain;

    //Cookie生命周期
    @Value("${auth.cookieMaxAge}")
    private int cookieMaxAge;


    /**
     * 密码模式  认证.
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public Result<Map> login(String username, String password) {

        if(StringUtils.isEmpty(username)){
            throw new RuntimeException("用户名不允许为空");
        }
        if(StringUtils.isEmpty(password)){
            throw new RuntimeException("密码不允许为空");
        }
        //登录 之后生成令牌的数据返回
        AuthToken authToken = loginService.login(username, password, clientId, clientSecret,GRAND_TYPE);
        //设置到cookie中
        //saveCookie(authToken.getAccessToken());
        if (null!=authToken){
            return new Result<>(true, StatusCode.OK,"登录成功",authToken);
        }
        return new Result<>(true, StatusCode.LOGINERROR,"登录失败");
    }

    private void saveCookie(String token){
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        CookieUtil.addCookie(response,cookieDomain,"/","Authorization",token,cookieMaxAge,false);
    }
}
