package com.example.redisintermediateproject.geospatial;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeService {

    public void addCafe(AddCafeRequestDto addCafeRequestDto) {
        return;
    }

    public List<Object> findCafesNearby(double longitude, double latitude, double distanceKm) {
        return null;
    }
}
