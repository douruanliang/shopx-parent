package com.shopx.oauth.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author linSir
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @Date 2020/1/6 19:11
 */
@Controller
public class ManagerWebController {


    @ApiOperation("登入页面")
    @GetMapping(value = "/oauth/formLogin")
    public String login(Model model) {
        model.addAttribute("loginProcessUrl", "loginProcessUrl");
        return "login";
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "login";
    }

    @GetMapping(value = "/error")
    public String error() {
        return "login";
    }

}
