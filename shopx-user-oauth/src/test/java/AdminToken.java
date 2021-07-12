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
        //String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhcHAiXSwibmFtZSI6bnVsbCwiaWQiOm51bGwsImV4cCI6MTk5OTIzODQwNywianRpIjoiNDQ2NDViMGUtMzdjZi00N2MxLWE0NDMtNjNkZGIzOWYzZGYyIiwiY2xpZW50X2lkIjoic3ppdGhlaW1hIiwidXNlcm5hbWUiOiJzeml0aGVpbWEifQ.YY1CXUYkzNc1fVjBwzcatqqUJlxLnFDcm7q5Q0yLsCo9NWMB-3NMfTa0QBJ3RfL17jw9eYtBkl9fHHUMzI4VDy4I2cIzTkYo-lC_J-6CLiH8-MPoPOXzN04gMS_Gxyh6rghtOhERkNfiiEodM2sOowq7211iMj3nb8N9eL3ggOCImuri2wbzZZh5SaqL66fRZqcnC4Bjta0YN0SxcOgqrWS6ZGy5GFwciVOZjWbFZE1-TxA8_eEtXLzkT9D-QkLdlBC5u0ETdHBVPf5CIFcCNUrtKg9V0waPeGOfgiryLn1rBWvi-RdDmLzaQMUmbl-sMOcT03Nsyp1sG6jawvaoIg";

        String token ="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiYWRtaW4iLCJpZCI6IjExMCIsImF1dGhvcml0aWVzIjpbImFkbWluIiwib2F1dGgiXX0.Si1rxlbbUlaoqBTJamAP24z3CZmFuh1xeRBJtCVccH6Wi4Ab5keEDopl60rYr0hRuomqtYXBtYn8Gf3z3_t15WKyJfMCQXAZVrJSjIbJfIpODKJiGzawZNjkvxmlbZ1rlIvXY79-a2v5QCMFWIpLkOEpH4TQjaLiddXfrjEqFONIn2XiGndss3ZS9EEWJYsrofzI_Q-4oqQeEfOCaOqVZW7g2pqdBnuFh6lxOPbNKhmkEtPRUiCq8vkRSHPFkLnc0PrepKnBQH9kBQa8uxrxbMsHrcSR05t0jX1YgJ-svx9g0DuvZ9TFL1XtFCcckTWqIZEAopzHdzyEbcjuU30pSg";
        //公钥
       // String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi7Drp7TubteIxAM71vQfH1trXsobxVrCAdONO3Moh6e+St0pP1IcLXBS5QtwF3dCIeCp9h9Tug0WZ3NRPJxBOl+h23nKgfnBpbqjQRa4/pZty4T4R9pqeVQtXpyUD1SyDCfy8hqVbd5wX+3l8+zHgKf3DmpEvfRxh0eRXcRV/5luU6T7Cu+7fu0eTbQpKT7gwDFRNRwhDIe+1uLgzmn/9ZpwtM7f3aumN97wFltsTMFlVFCr/3UDJXRt8opm2Qm3Z+vDA4x7qFgW5dVmXU3nCp7pjBK1zRMDnemRjiizo3Ha1mR9SJBA6zYgt1ZV71kndOjn5pPnq9f3RIZIAMgDyQIDAQAB-----END PUBLIC KEY-----";
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
