package com.example.baseproject.dto;

import lombok.Data;

@Data
public class DepartmentDto {
    private long departmentId;
    private String departmentName;
    private String departmentCode;
    private boolean enable = true;
}
