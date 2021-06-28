package com.shopx.oauth.util;

import com.alibaba.fastjson.JSON;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

/**
 * Package: com.shopx.oauth.util
 * Description： 构建管理员令牌
 * Author: douruanliang
 * Date: Created in 2021/6/27 下午11:20
 * Company: 公司
 * Copyright: Copyright (c) 2021
 * Version: 0.0.
 * Modified By:
 */

public class AdminToken {

    public static String adminToken() {
        //证书文件路径
        String key_location = "shopxserver.jks";
        //秘钥库密码
        String key_password = "outputdourl";
        //秘钥密码
        String keypwd = "inputdourl";
        //秘钥别名
        String alias = "dourl";

        //访问证书路径 读取jks的文件
        ClassPathResource resource = new ClassPathResource(key_location);

        //创建秘钥工厂
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(resource, key_password.toCharArray());

        //读取秘钥对(公钥、私钥)
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias, keypwd.toCharArray());

        //获取私钥
        RSAPrivateKey rsaPrivate = (RSAPrivateKey) keyPair.getPrivate();

        //自定义Payload
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("id", "110");
        tokenMap.put("name", "admin");
        tokenMap.put("authorities", new String[]{"admin", "oauth"});

        //生成Jwt令牌
        Jwt jwt = JwtHelper.encode(JSON.toJSONString(tokenMap), new RsaSigner(rsaPrivate));

        //取出令牌
        String token = jwt.getEncoded();
        System.out.println(token);
        return token;
    }
}
