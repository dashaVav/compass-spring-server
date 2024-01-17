package com.example.compass.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RangesOfCardinalDirectionsDTO {
    private String north;
    private String northeast;
    private String east;
    private String southeast;
    private String south;
    private String southwest;
    private String west;
    private String northwest;
}
