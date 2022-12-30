package com.example.webcsf;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    private  static final long serialVersionUID = 1L;

    private MemberService memberService;
    public LoginController(){
        super();
        memberService = MemberServiceImpl.getInstance();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("로그인 요청");
        //webapp 디렉토리의 member 디렉토리의 login.jsp 로 포워딩
        request.getRequestDispatcher("/member/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //로그인 처리
        //파라미터 가져오기
        String mid = request.getParameter("mid");
        String mpw = request.getParameter("mpw");

        //서비스 메서드 호출
        MemberDTO dto = memberService.login(mid, mpw);
        //결과를 가지고 분기
        HttpSession session = request.getSession();
        if(dto==null){
            session.invalidate();
            //로그인 페이지로 돌아가기
            response.sendRedirect("login?error=error");
        }else{
            session.setAttribute("logininfo", dto);
            //메인 페이지로 리다이렉트
            response.sendRedirect("./");
        }
    }
}
