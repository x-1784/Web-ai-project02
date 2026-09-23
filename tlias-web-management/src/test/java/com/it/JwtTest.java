package com.it;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {


    /**
     * 生成JWT令牌
     */
    @Test
    public void testGenerateJwt(){
        Map<String, Object> dataMap =new HashMap<>();
        dataMap.put("id",1);
        dataMap.put("username","admin");

        String jwt= Jwts.builder().signWith(SignatureAlgorithm.HS256,"aXRoZWltYQ==")//指定加密算法，密钥
                .addClaims(dataMap)//添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))//设置有效时间，时间到了会过期
                .compact();//生成令牌
        System.out.println(jwt);
    }

    /**
     * 解析jwt令牌      解析令牌如过报错，原因1.令牌被篡改  2.令牌过期
     * JWT校验时使用的签名密钥，必须和生成jwt令牌时使用的密钥是配套的
     */
    @Test
    public void testParseJWT(){
        String token="eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc5MDE2NzYyMn0.RZ3Tyb0IoaL7WUBxocHENXHdTAHxz9j_NO_9uFTYqy0";
        Claims claims = Jwts.parser()
                .setSigningKey("aXRoZWltYQ==")  //指定密钥
                .parseClaimsJws(token)  //解析令牌
                .getBody();  //获取自定义信息
        System.out.println(claims);
    }

}










































