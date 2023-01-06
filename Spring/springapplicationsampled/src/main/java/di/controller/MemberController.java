package di.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import di.service.MemberService;
import lombok.RequiredArgsConstructor;

// Controller는 다른 클래스에 주입되지 않기 때문에
//templete method 패턴을 사용하지 않음
@RequiredArgsConstructor
@Controller
public class MemberController {
	//Service 주입
	//@Autowired
	private final MemberService memberService;
	public void findById(String id) {
		System.out.println(memberService.findById(id));
	}
}
