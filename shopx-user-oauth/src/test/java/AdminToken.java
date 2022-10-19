import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

/**
 * Package: com.shopx.oauth.util
 * Description： TODO
 * Author: douruanliang
 * Date: Created in 2021/6/27 下午11:20
 * Company: 公司
 * Copyright: Copyright (c) 2021
 * Version: 0.0.
 * Modified By:
 */

public class AdminToken {
    @Test
    public  void adminToken() {
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

    }

    @Test
    public void testParseToken(){
        //令牌
        //String token ="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiYWRtaW4iLCJpZCI6IjExMCIsImF1dGhvcml0aWVzIjpbImFkbWluIiwib2F1dGgiXX0.Si1rxlbbUlaoqBTJamAP24z3CZmFuh1xeRBJtCVccH6Wi4Ab5keEDopl60rYr0hRuomqtYXBtYn8Gf3z3_t15WKyJfMCQXAZVrJSjIbJfIpODKJiGzawZNjkvxmlbZ1rlIvXY79-a2v5QCMFWIpLkOEpH4TQjaLiddXfrjEqFONIn2XiGndss3ZS9EEWJYsrofzI_Q-4oqQeEfOCaOqVZW7g2pqdBnuFh6lxOPbNKhmkEtPRUiCq8vkRSHPFkLnc0PrepKnBQH9kBQa8uxrxbMsHrcSR05t0jX1YgJ-svx9g0DuvZ9TFL1XtFCcckTWqIZEAopzHdzyEbcjuU30pSg";
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhcHAiXSwibmFtZSI6bnVsbCwiaWQiOm51bGwsImV4cCI6MjA5NzkyMDQzMywiYXV0aG9yaXRpZXMiOlsic2Vja2lsbF9saXN0IiwiZ29vZHNfbGlzdCJdLCJqdGkiOiJkZDc0ZDUyMi0zMzI5LTRlZDItODY1ZC00ZmUxZWMwYjgwOWEiLCJjbGllbnRfaWQiOiJjaGFuZ2dvdSIsInVzZXJuYW1lIjoic3ppdGhlaW1hIn0.C6IsfjhHMOPcdOR6c6ORwyCqVR-StRsg28I56jsttgexhtEoalWcy5CE1SoAZsbEj4eFo-stB00XdbIRsM1VsPSd30UPb6T2HTsoSN0ylma2_AiMijzdjUzFXWriXqLhoAhHPOoSgdi1p-yOfCluMJkdN4UBOsCBja18Impgiz8FyqHxvx7sAc7sUIh3BUZRZcCIfcNoCJBZPi5Fwwa8UoFvYk0qpnQq6LHbUC9DAmVwR7RoioJj1CAliEI_9FihDkCjftxY89kmqhy7nm8JL9LQZYLyjEf1s4eA2COGQkToGrVDTiEZvjeGOv-BqSe4SFiCVRo2W29Uy6ztbkvF9w";
        //公钥
        String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhmHzNjohEPD/5OCgYlt72vyf/+S6G8PmxOUzVp9Dc0EVjHZY88iL9RTAqEAMVs211C/f528K9+r5b2IwNMTmdk4467Pejj+aBWBRQgxajNRKU7gXQcdMpa1S6qKAD2UnlHDgAl0IaqczSDFZdwJdQ9yxTU+f7FLclrkOogzIz3/z0y+F/tkDwRgAq5Dr7jXQqRwqqmUNRCNwRFjzOj2uUDt6WJxWZTzRKexeRObTVVab5QOAnRxjIgvVUJF8BQaQfl4mt6PS16PquQ5MyRmwEK8h6o4zHeozPYYE62e41/9G8IMMG8QIi/PnDgCO4JeUUj5pkCc1dReVDiT+L9JqlQIDAQAB-----END PUBLIC KEY-----";
        //校验Jwt
        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(publickey));

        //获取Jwt原始内容 载荷
        String claims = jwt.getClaims();
        System.out.println(claims);
        //jwt令牌
        String encoded = jwt.getEncoded();
        System.out.println(encoded);
    }
}
