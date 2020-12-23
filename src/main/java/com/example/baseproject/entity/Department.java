package com.example.baseproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long departmentId;
    @Column
    private String departmentName;
    @Column
    private String departmentCode;
    @Column
    private boolean enable = true;

}
