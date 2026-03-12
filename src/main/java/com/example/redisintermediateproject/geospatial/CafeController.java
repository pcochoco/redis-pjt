package com.example.redisintermediateproject.geospatial;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {

    private final CafeService cafeService;

    // Redis에 카페 데이터 추가하는 API
    @PostMapping
    public void addCafe(@RequestBody AddCafeRequestDto addCafeRequestDto) {
        cafeService.addCafe(addCafeRequestDto);
    }

    // 특정 위치를 기준으로 지정된 반경 내에 있는 카페를 조회해주는 API
    @GetMapping("/nearby")
    public List<Object> findCafesNearby(@RequestParam double longitude,
                                        @RequestParam double latitude,
                                        @RequestParam double distance) {
        return cafeService.findCafesNearby(longitude, latitude, distance);
    }
}
