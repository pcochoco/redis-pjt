package com.example.redisintermediateproject.auth;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(
        @RequestBody LoginRequestDto loginRequest,
        HttpSession session
    ) {
        // 간단한 예제로 실습하기 위해, 로그인 할 사용자 정보 조회를 하드코딩으로 대체.
        // 실제 구현에서는 로그인을 하기 위한 정보를 DB에서 조회해야 함.
        String account = "jscode";
        String password = "password";
        String name = "박재성";
        long userId = 1;

        if (account.equals(loginRequest.getAccount()) && password.equals(loginRequest.getPassword())) {
            // 로그인 성공 시 세션에 사용자 정보(userId, name 등) 저장한다.
            // 세션 정보는 Spring Boot에 내장된 톰캣의 인메모리에 저장된다.
            session.setAttribute("userId", userId);
            session.setAttribute("name", name);

            // 간단한 실습을 위해 String으로 심플하게 응답.
            return "로그인 성공";
        } else {
            return "로그인 실패";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        // 간단한 실습을 위해 String으로 심플하게 응답.
        return "로그아웃 성공";
    }

    // 내 정보 조회 API
    @GetMapping("/me")
    public String status(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        String name = (String) session.getAttribute("name");

        // 간단한 실습을 위해 String으로 심플하게 응답.
        if (userId == null) {
            return "로그인이 필요합니다.";
        } else {
            return "userId : " + userId + ", " + "name : " + name;
        }
    }
}
