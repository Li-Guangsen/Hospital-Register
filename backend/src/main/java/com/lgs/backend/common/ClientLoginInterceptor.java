package com.lgs.backend.common;

import com.lgs.backend.model.Patient;
import com.lgs.backend.utils.WebAppUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

public class ClientLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Patient patient = (Patient) request.getSession().getAttribute("patient");
        if (patient == null) {
            response.setStatus(401);
            //Ajax请求
            if(request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
                WebAppUtils.writeJson(response, Map.of("success",false,"msg","未登录"));
            }else {
                // 未登录，重定向到登录页
                response.sendRedirect("/client/login");
            }
            return false;

        }
        return true;
    }
}
