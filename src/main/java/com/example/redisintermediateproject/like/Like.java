package com.example.redisintermediateproject.like;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "likes")
@Getter
@NoArgsConstructor
public class Like {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long userId;

  private Long postId;

  public Like(Long userId, Long postId) {
    this.userId = userId;
    this.postId = postId;
  }
}
