package com.example.redisintermediateproject.geospatial;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddCafeRequestDto {
    private String name;
    private double longitude;
    private double latitude;
}

