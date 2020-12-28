package com.example.baseproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courseId;
    @Column
    private String courseName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "courseId"))
    private Student student;
}
