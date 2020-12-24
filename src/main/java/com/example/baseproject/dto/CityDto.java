package com.example.baseproject.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CityDto {
    private long cityId;
    private String cityName;
}
