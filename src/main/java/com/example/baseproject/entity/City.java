package com.example.baseproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "City")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cityId;
    @Column
    private String cityName;
}
