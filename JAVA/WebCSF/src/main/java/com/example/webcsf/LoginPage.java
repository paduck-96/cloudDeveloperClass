package com.example.webcsf;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "LoginPage")
public class LoginPage implements Filter {
    //메모리 할당 후 처음 사용될 때 호출
    public void init(FilterConfig config) throws ServletException {
    }

    //필터 파괴시 호출
    public void destroy() {
    }

    // URL에 해당하는 요청 왔을 떄 호출되는 메서드
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //Controller 가 처리하기 전에 수행
        System.out.println("처리하기 전");
        chain.doFilter(request, response);
        //COntroller 가 처리한 후에 수행
        System.out.println("처리한 후");
    }
}
