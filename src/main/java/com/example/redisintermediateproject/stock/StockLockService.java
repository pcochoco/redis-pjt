package com.example.redisintermediateproject.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class StockLockService {
    private final RedisTemplate<String, String> redisTemplate;
    private final StockService stockService;

    public void decreaseWithRedis(Long id) throws InterruptedException {
        String key = "stock_lock:" + id;

        while (!tryLock(key)) { //락 획득 불가 시
            Thread.sleep(100);
        }

        try{
            stockService.decrease(id);
        } finally {
            redisTemplate.delete(key);
        }
    }

    //
    private boolean tryLock(String key){
        //set [key] [value] nx ex [seconds] 와 동일
        return redisTemplate
            .opsForValue()
            .setIfAbsent(key, "lock", Duration.ofMillis(3_000)); //key, value, 유효시간

    }

}
