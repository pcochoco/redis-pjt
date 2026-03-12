package com.example.redisintermediateproject.dau;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyActiveUserRepository extends JpaRepository<DailyActiveUser, Long> {
    // 특정 사용자가 특정 날짜에 활동(방문)했는지 확인
    boolean existsByUserIdAndActiveDate(Long userId, LocalDate activeDate);

    // 특정 날짜의 DAU를 계산
    long countByActiveDate(LocalDate activeDate);

}
