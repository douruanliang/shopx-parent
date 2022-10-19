package com.shopx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 描述
 *
 * @author
 * @version 1.0
 * @package com.changgou *
 * @since 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayWebApplication.class,args);
    }
     // IP 限流
    //创建一个ipKeyResolver 指定用户的IP --用于计算某一个类型的限流的KEK 这里是IP
    @Bean(name="ipKeyResolver")
    public KeyResolver keyResolver(){
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                //1.获取请求request对象
                ServerHttpRequest request = exchange.getRequest();
                //2.从request中获取ip地址
                String hostString = request.getRemoteAddress().getHostString();//Ip地址
                //3.返回
                return Mono.just(hostString);
            }
        };
    }

}
