package com.kakao.security.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class SampleController {
    @GetMapping("/")
    public String index(){
        log.info("메인");
        return "/index";
    }

    @GetMapping("/sample/all")
    public void all(){
        log.info("모두 허용");
    }

    // 로그인한 ㅇ ㅠ저만 접속이 가능
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/sample/member")
    public void member(){
        log.info("멤버만 허용");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/sample/admin")
    public void admin(){
        log.info("관리자만 허용");
    }
    
}
