package com.example.webcsf;

public interface MemberService {
    // 로그인 처리 메서드
    public MemberDTO login(String mid, String mpw, String uuid);
    // 자동 로그인 처리 메서드
    public MemberDTO login(String uuid);
}
