package com.example.redisintermediateproject.like;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;

    public void likePost(LikePostRequestDto likePostRequestDto) {
        Long userId = likePostRequestDto.getUserId();
        Long postId = likePostRequestDto.getPostId();
        Like like = new Like(userId, postId);
        likeRepository.save(like);
    }
}
