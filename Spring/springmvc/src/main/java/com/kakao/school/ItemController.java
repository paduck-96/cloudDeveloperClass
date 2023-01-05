package com.kakao.school;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kakao.school.domain.Command;
import com.kakao.school.dto.ItemDto;
import com.kakao.school.service.ItemService;

import lombok.RequiredArgsConstructor;

/**
 * Handles requests for the application home page.
 */
// Controller 만들기 위한 어노테이션
@Controller
@RequiredArgsConstructor
public class ItemController {
	//로그 기록 객체
	//private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	private final ItemService itemService;
	// Get 요청에 처리
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String home(Model model) {
		List<ItemDto> list = itemService.allItem();
		// 결고 저장
		model.addAttribute("result", list);
		return "hello";
	}
	
//	//hello 요청을 GET 방식으로 전송했을 때 처리
//	@RequestMapping(value="hello", method=RequestMethod.GET)
//	public String hello(Model model) {
//		model.addAttribute("message", "Controller 에서 뷰에게 전달하는 데이터");
//		return "hello";
//	}
//	
//	@RequestMapping(value="message/detail/{num}", method=RequestMethod.GET)
//	public String detail(Model model, @PathVariable("num") Integer nums) {
//		model.addAttribute("num: ", nums);
//		return "detail";
//	}
//	
//	@RequestMapping(value="param1", method=RequestMethod.GET)
//	public String param1(Model model, HttpServletRequest request) {
//		// 전통적인 자바 웹 프로그래밍에서 파라미터 읽기
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//		System.out.println("name" + name +"\n"+"pw"+password);
//		return "";
//	}
//	
//	@RequestMapping(value="param2", method=RequestMethod.POST)
//	public String param2(Model model,
//			@RequestParam("name") String name,
//			@RequestParam("password") String pw) {
//		System.out.println("name" + name +"\n"+"pw"+ pw);
//		return "";
//	}
//	
//	@RequestMapping(value="param3", method=RequestMethod.POST)
//	public String param2(Model model, Command command) {
//		System.out.println(command);
//		return "";
//	}
//	@RequestMapping(value="redirect", method=RequestMethod.GET)
//	public String redirect(Model model, HttpSession session,
//			RedirectAttributes rattr) {
//		// request.setAttribute("msg", 내용) 으로 데이터 생성과 동일
//		// redirect 로 이동시 request 데이터 전달되지 않음
//		//request 새로 생성
//		//session 이나 RedirectAttributes 이용
//		model.addAttribute("msg", "리다이렉트 연습");
//		// 브라우저 종료하거나 세션 제거하지 않는 이상 계속 유지
//		//session.setAttribute("msg", "세션을 이용한 리다이렉트");
//		rattr.addFlashAttribute("msg", "일회용 데이터 전달");
//		// 리다이렉트 시 redirect: 다음에 URL 설정
//		return "redirect:disp";
//	}
//	@RequestMapping(value="disp", method=RequestMethod.GET)
//	public String disp(Model model) {
//		return "redirect";
//	}
}
