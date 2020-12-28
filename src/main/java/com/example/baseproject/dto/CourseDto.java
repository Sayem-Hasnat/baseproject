package com.example.baseproject.dto;

import com.example.baseproject.entity.Student;
import lombok.Data;

import javax.persistence.Column;

@Data
public class CourseDto {
    private long courseId;
    private String courseName;
    private StudentDto studentDto;
}
