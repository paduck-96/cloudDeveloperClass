package com.kakao.review.aop;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MeasuringInterceptor implements HandlerInterceptor {
    // Controller에게 요청하기 전 호출되는 메서드
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler){
        log.warn("Controller가 요청을 처리하기 전에 호출")
        return true;
    }

    // Controller가 요청을 정상적으로 처리한 후 호출되는 메서드
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView){
        log.warn("요청을 정상적으로 처리한 후 호출");
    }

    // Controller가 요청을 처리한 후 무조건 호출되는 메서드
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception e){
    }
}
