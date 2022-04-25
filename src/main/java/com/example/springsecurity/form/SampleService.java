package com.example.springsecurity.form;

import com.example.springsecurity.conmmon.SecurityLogger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class SampleService {

    public void dashboard() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // principal 인증을 한 사용자
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        // 인증을 한 사용자 권한
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        // 인증된 사용자이냐
        boolean authenticated = authentication.isAuthenticated();
    }

    /** 
     * 비동기로 처리해주도록 하는 어노테이션
     * */
    @Async
    public void asyncService() {
        SecurityLogger.log("Async Service");
        System.out.println("Async service is called.");
    }
}
