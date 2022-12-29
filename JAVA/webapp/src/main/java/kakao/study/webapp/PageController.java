package kakao.study.webapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PageController", value = "/PageController")
public class PageController extends HttpServlet {

    // 서비스에 대한 참조 변수
    private PageService pageService;

    public PageController(){
        //생성자에서 서비스 생성
        pageService = new PageServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 파라미터 읽기
        String first = request.getParameter("first");
        String second = request.getParameter("second");

        // 서비스 메서드 호출
        //파라미터의 자료형 변환은 Service에서 수행 가능
        //Spring은 일반적으로 Controller에서 진행
        int result = pageService.add(Integer.parseInt(first), Integer.parseInt(second));

        //결과를 저장
        request.setAttribute("result", result);
        // 세션 없을경우 request 에서 생성
        request.getSession().setAttribute("result", result); 
        // application 없을 경우 request에서 생성
        request.getServletContext().setAttribute("result", result);

        // 뷰 페이지 결정하고 데이터를 전달
        response.sendRedirect("output.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
    }
}
