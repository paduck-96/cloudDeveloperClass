package com.kakao.security.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CustomUserDetailService implements UserDetailsService {
    private PasswordEncoder passwordEncoder;
    public CustomUserDetailService(){
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // 아이디 입력 후 로그인 요청하게 되면
    //아이디에 해당하는 데이터 찾아오는 메서드
    //이후에 로그인 처리 진행
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername: " + username);

        //로그인 성공 시
        UserDetails userDetails = User.builder()
                .username("user1")
                .password(passwordEncoder.encode("1111"))
                .authorities("ROLE_USER")
                .build();
        return userDetails;
    }
}
