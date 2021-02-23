package com.atguigu.gmall.auth;

import com.atguigu.gmall.common.utils.JwtUtils;
import com.atguigu.gmall.common.utils.RsaUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    // 别忘了创建D:\\project\rsa目录
	private static final String pubKeyPath = "E:\\atguigu\\java0821\\stu\\GULISHOPPING\\gamll-0821\\rsa\\rsa.pub";
    private static final String priKeyPath = "E:\\atguigu\\java0821\\stu\\GULISHOPPING\\gamll-0821\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    //@BeforeEach
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "11");
        map.put("username", "liuyan");
        // 生成token
        String token = JwtUtils.generateToken(map, privateKey, 2);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6IjExIiwidXNlcm5hbWUiOiJsaXV5YW4iLCJleHAiOjE2MTM5OTA0OTl9.sRuJ0YYw0PyGUWCTUoUO2SI7Y4kFWfpvOPXtS4dE7Y24xZNqKx0Lw-zsYSxeXfXnxMYKc6JGfAE8sJDklbFHsB2lgu7n_lpzv1qBYJ109HL2nDndhnG8GoCA4dTU7QNnzP33xKb-LSrhydwyXhfkMRH9JgA6bWs5H8QG11YnS8RsJoD--yrgDFHuGBnnhAvK8z6gP6EPFztDEikxu0q_Y3Ud8fQN8QX6wy6K5TzukaNpZGorR4cd5wlFxkPqnHLWsJkShJLjUM2uZ43oGxqx2o9BQ6rg6J2n4ZB9SaVVnKAaizcaaFWJrgXNGY_VjMSnsQO8dFzY8RdQ-rqpbmcBRQ\n";

        // 解析token
        Map<String, Object> map = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + map.get("id"));
        System.out.println("userName: " + map.get("username"));
    }
}