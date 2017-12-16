package com.vinfai.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * request attribute add context
 *
 * @author fangwenhui
 * @date 2017-12-15 18:45
 **/
@Component
public class ContextInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(request.getContextPath());
        request.setAttribute("ctx", request.getContextPath());

    }
}
