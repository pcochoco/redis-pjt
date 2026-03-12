package com.example.redisintermediateproject.keyword;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SearchRepository extends JpaRepository<SearchKeyword, Long> {
    Optional<SearchKeyword> findByKeyword(String word);
    List<SearchKeyword> findTop10ByOrderByCountDesc();
}
