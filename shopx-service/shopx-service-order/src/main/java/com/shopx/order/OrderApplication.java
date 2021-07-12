package com.shopx.order;

import entity.FeignInterceptor;
import entity.IdWorker;
import entity.TokenDecode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 描述
 *
 * @author dourl
 * @version 1.0
 * @package com.shopx *
 * @since 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.shopx.order.dao")
@EnableFeignClients(basePackages = {"com.shopx.goods.feign","com.shopx.user.feign"})
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    public FeignInterceptor creatFeignInterceptor() {
        return new FeignInterceptor();
    }
    @Bean
    public TokenDecode tokenDecode(){
        return new TokenDecode();
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(0,0);
    }
}
