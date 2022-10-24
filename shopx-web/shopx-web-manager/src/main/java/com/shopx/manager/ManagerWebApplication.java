package com.shopx.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * 项目启动类
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.shopx.manager.feign")
public class ManagerWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerWebApplication.class, args);
    }
}
