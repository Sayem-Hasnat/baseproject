package com.example.baseproject.service;

import com.example.baseproject.dto.DepartmentDto;
import com.example.baseproject.dto.StudentDto;
import com.example.baseproject.entity.Department;
import com.example.baseproject.entity.Student;
import com.example.baseproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepo;

    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void save(Student student) {
        studentRepo.save(student);
    }


    public  List<Student> getAllEnabled() {
        List<Student> studentList = studentRepo.findAllByEnableTrue();
        return studentList;
    }
}
