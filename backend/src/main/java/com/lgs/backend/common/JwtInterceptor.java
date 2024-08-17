package com.lgs.backend.common;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.lgs.backend.utils.JwtUtils;
import com.lgs.backend.utils.WebAppUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

public class JwtInterceptor implements HandlerInterceptor {
    private String secretKey;
    public JwtInterceptor(String secretKey) {
        this.secretKey = secretKey;
    }
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        //1.获取请求头中的token
        String jwt = req.getHeader("jwt");//请求头名称任意
        //2.解析token
        try {
            //使用系统密钥解析请求token
            DecodedJWT decodedJWT = JwtUtils.decode(jwt, secretKey);
            return true;
        } catch (Exception e) {
            System.out.println("token解析失败");
            WebAppUtils.writeJson(resp, Map.of("code", 401, "error", "token解析失败"));
            return false;
        }

    }
}
