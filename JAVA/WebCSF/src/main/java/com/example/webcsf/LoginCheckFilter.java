package com.example.webcsf;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class LoginCheckFilter extends HttpFilter implements Filter {
    private MemberService memberService;
    public LoginCheckFilter(){
        super();
        memberService = MemberServiceImpl.getInstance();
    }
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //request 와 response 형 변환
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        //Login 요청이 오면
        //프로젝트이름/경로
        if(req.getRequestURI().equals("/WebCSF/login")){
            //쿠키 읽기
            Cookie [] cookies = req.getCookies();
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("rememberKey")){
                    String uuid = cookie.getValue();
                    MemberDTO dto = memberService.login(uuid);
                    req.getSession().setAttribute("logininfo", dto);
                    // 메인페이지로 리다이렉트
                    res.sendRedirect("./");
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }
}
