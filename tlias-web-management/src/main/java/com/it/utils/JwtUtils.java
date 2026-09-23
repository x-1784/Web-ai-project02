package com.it.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // 密钥
    private static final String SECRET_KEY = "aXRoZWltYQ==";

    /**
     * 生成JWT令牌
     *
     * @param claims JWT中要存储的数据
     * @return JWT令牌
     */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)  //指定加密算法，密钥
                .addClaims(claims)  //添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 * 1000))  //设置有效时间，时间到了会过期
                .compact();  //生成令牌
    }

    /**
     * 解析jwt令牌      解析令牌如过报错，原因1.令牌被篡改  2.令牌过期
     *      JWT校验时使用的签名密钥，必须和生成jwt令牌时使用的密钥是配套的
     * @param token JWT令牌
     * @return JWT中的数据
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY) //指定密钥
                .parseClaimsJws(token)        //解析令牌
                .getBody();  //获取自定义信息
    }
}