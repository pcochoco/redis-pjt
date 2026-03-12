package com.example.redisintermediateproject.keyword;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository searchRepository;

    @Transactional
    public void search(String keyword) {
        SearchKeyword searchKeyword = searchRepository.findByKeyword(keyword)
                .orElse(new SearchKeyword(keyword));
        searchKeyword.increaseCount();
        searchRepository.save(searchKeyword);
    }

    @Transactional(readOnly = true)
    public List<String> getTop10Keywords() {
        return searchRepository.findTop10ByOrderByCountDesc().stream()
                .map(SearchKeyword::getKeyword)
                .toList();
    }
}
