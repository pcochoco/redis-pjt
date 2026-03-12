package com.example.redisintermediateproject.dau;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "daily_active_users")
@Getter
@NoArgsConstructor
public class DailyActiveUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long userId;

  private LocalDate activeDate;

  public DailyActiveUser(Long userId, LocalDate activeDate) {
    this.userId = userId;
    this.activeDate = activeDate;
  }
}
