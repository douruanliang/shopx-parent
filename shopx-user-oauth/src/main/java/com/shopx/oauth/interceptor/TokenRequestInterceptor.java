package com.shopx.oauth.interceptor;

import com.shopx.oauth.util.AdminToken;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * Package: com.shopx.oauth.interceptor
 * Description： Feign 调用之前应该做的事儿
 * Author: douruanliang
 * Date: Created in 2021/6/27 下午8:04
 * Company: 公司
 * Copyright: Copyright (c) 2021
 * Version: 0.0.
 * Modified By:
 */
@Configuration
public class TokenRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String adminToken = AdminToken.adminToken();
        requestTemplate.header("Authorization", "bearer " + adminToken);
    }
}
