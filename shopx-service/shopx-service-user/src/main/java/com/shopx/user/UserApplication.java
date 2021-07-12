package com.shopx.user;

import entity.FeignInterceptor;
import entity.TokenDecode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 描述
 *
 * @author
 * @version 1.0
 * @since 1.0
 */
@SpringBootApplication
@EnableEurekaClient
//mapper扫描 用通用的mapper扫描器
@MapperScan("com.shopx.user.dao")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
    @Bean
    public FeignInterceptor creatFeignInterceptor() {
        return new FeignInterceptor();
    }

    @Bean
    public TokenDecode tokenDecode(){
        return new TokenDecode();
    }
}
