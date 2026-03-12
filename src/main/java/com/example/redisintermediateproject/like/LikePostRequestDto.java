package com.example.redisintermediateproject.like;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LikePostRequestDto {
    private Long userId;
    private Long postId;
}
