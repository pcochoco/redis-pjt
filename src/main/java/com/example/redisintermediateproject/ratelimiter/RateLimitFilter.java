package com.example.redisintermediateproject.ratelimiter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class RateLimitFilter extends OncePerRequestFilter {
    //OncePerRequestFilter : http request 요청 하나 당 한번씩 필터 적용
    //모든 api 에 해당
    public final RateLimiter rateLimiter;

    @Override
    protected void doFilterInternal(
           HttpServletRequest request,
           HttpServletResponse response,
           FilterChain filterChain
    ) throws ServletException, IOException{

        //http request header에 추가
        String userId = request.getHeader("USER-ID");

        if(userId == null) return;

        if(!rateLimiter.allow(userId)){
            response.setStatus(429); //too many requests
        }

        filterChain.doFilter(request, response);
    }
}
