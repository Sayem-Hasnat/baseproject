package com.example.baseproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;
    @Column
    private String studentName;
    @Column
    private int studentAge;
    @Column
    private String studentGender;
    @Column
    private boolean enable=true;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId")
    private Department department;
}
