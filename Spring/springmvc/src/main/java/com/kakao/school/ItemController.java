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
// Controller ����� ���� ������̼�
@Controller
@RequiredArgsConstructor
public class ItemController {
	//�α� ��� ��ü
	//private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	private final ItemService itemService;
	// Get ��û�� ó��
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String home(Model model) {
		List<ItemDto> list = itemService.allItem();
		// ��� ����
		model.addAttribute("result", list);
		return "hello";
	}
	
//	//hello ��û�� GET ������� �������� �� ó��
//	@RequestMapping(value="hello", method=RequestMethod.GET)
//	public String hello(Model model) {
//		model.addAttribute("message", "Controller ���� �信�� �����ϴ� ������");
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
//		// �������� �ڹ� �� ���α׷��ֿ��� �Ķ���� �б�
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
//		// request.setAttribute("msg", ����) ���� ������ ������ ����
//		// redirect �� �̵��� request ������ ���޵��� ����
//		//request ���� ����
//		//session �̳� RedirectAttributes �̿�
//		model.addAttribute("msg", "�����̷�Ʈ ����");
//		// ������ �����ϰų� ���� �������� �ʴ� �̻� ��� ����
//		//session.setAttribute("msg", "������ �̿��� �����̷�Ʈ");
//		rattr.addFlashAttribute("msg", "��ȸ�� ������ ����");
//		// �����̷�Ʈ �� redirect: ������ URL ����
//		return "redirect:disp";
//	}
//	@RequestMapping(value="disp", method=RequestMethod.GET)
//	public String disp(Model model) {
//		return "redirect";
//	}
}
