package com.example.redisintermediateproject.ratelimiter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class RateLimiter {

    private static final long RATE_LIMIT_TIME_MS = 10_000; //만 ms = 10초
    private static final long MAX_REQUESTS = 5; //5 요청 제한

    private final RedisTemplate<String, String> redisTemplate;

    public boolean allow(String userId){
        long now = System.currentTimeMillis();

        String redisKey = "rate_limit:" + userId; //ip 로 대체 가능
        String requestId = UUID.randomUUID().toString();

        redisTemplate
                .opsForZSet()
                .removeRangeByScore(redisKey, 0, now);

        Long count = redisTemplate
                .opsForZSet()
                .size(redisKey);

        redisTemplate
                .opsForZSet()
                .add(redisKey, requestId, now);

        redisTemplate.expire(redisKey, RATE_LIMIT_TIME_MS, TimeUnit.MILLISECONDS);

        return count <= MAX_REQUESTS;
    }
}
