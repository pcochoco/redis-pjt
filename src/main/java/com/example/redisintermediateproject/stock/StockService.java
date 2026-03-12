package com.example.redisintermediateproject.stock;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

  private final StockRepository stockRepository;

  @Transactional
  public void decrease(Long id) {
    Stock stock = stockRepository.findById(id).orElseThrow();
    stock.decrease(id);
    stockRepository.save(stock);
  }
}
