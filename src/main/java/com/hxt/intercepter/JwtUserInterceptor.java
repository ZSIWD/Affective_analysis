package com.hxt.intercepter;

import com.hxt.properties.JwtProperties;
import com.hxt.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class JwtUserInterceptor implements HandlerInterceptor {
    @Resource
    private JwtProperties jwtProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //拦截到的是静态资源，直接放行
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        String token = request.getHeader(jwtProperties.getJwtTokenName());
        try{
            System.out.println("token为："+token);
            //校验token
            Claims claims = JwtUtil.parseJwt(jwtProperties.getJwtSecretKey(), token);
            String username  = (String) claims.get("用户名");
            request.setAttribute("username", username);
            log.info("用户{}登录成功", username);
            return true;
        }
        //解析token失败
        catch (Exception e){
            //不通过，设置响应码
            System.out.println(e);
            response.setStatus(401);
            return false;
        }
    }
}
