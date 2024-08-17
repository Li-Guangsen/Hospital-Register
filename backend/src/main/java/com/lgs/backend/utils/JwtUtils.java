package com.lgs.backend.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class JwtUtils {
    /**
     *
     * @param payload 有效载荷 主体数据
     * @param key 密钥
     * @return jwt令牌
     */
    public static String encode(Map<String,Object> payload, String key){
        JWTCreator.Builder builder = JWT.create();
        // 添加有效载荷
        builder.withPayload(payload);
        //过期时间
        builder.withExpiresAt(Instant.now().plusSeconds(1800));
        //签名
        builder.withIssuer("lgs");
        builder.withJWTId(UUID.randomUUID().toString());
        return builder.sign(Algorithm.HMAC256(key));//HMAC256对称加密 KEY参数
    }
    /**
     * 解码jwt令牌
     * @param key 密钥
     */
    public static DecodedJWT decode(String jwt, String key) {
        return JWT.require(Algorithm.HMAC256(key)).build().verify(jwt);//HMAC256对称解密 KEY参数
    }
}
