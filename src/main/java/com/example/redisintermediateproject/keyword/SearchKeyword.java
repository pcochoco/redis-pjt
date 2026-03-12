package com.example.redisintermediateproject.keyword;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "search_keywords")
@Getter
@NoArgsConstructor
public class SearchKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String keyword;

    private Long count;

    public SearchKeyword(String keyword) {
        this.keyword = keyword;
        this.count = 1L;
    }

    public void increaseCount() {
        this.count++;
    }
}
