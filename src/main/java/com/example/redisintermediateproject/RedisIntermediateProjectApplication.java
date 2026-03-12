package com.example.redisintermediateproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
//@EnableScheduling //scheduler 용도
@SpringBootApplication
public class RedisIntermediateProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(RedisIntermediateProjectApplication.class, args);
  }

}
