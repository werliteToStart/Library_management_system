package com.example.config;

import com.example.bean.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ((User)request.getSession().getAttribute("user")==null){
            request.setAttribute("msg","没有限权，请登录");
            request.getRequestDispatcher("/login").forward(request,response);

            return false;
        }else {
            return true;
        }


    }
}
