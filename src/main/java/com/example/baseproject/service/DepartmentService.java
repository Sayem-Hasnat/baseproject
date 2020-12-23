package com.example.baseproject.service;

import com.example.baseproject.dto.DepartmentDto;
import com.example.baseproject.entity.Department;
import com.example.baseproject.repository.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private final DepartmentRepository departmentRepo;

    public DepartmentService(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public void save(DepartmentDto departmentDtoForm) {
        Department department =new Department();
        BeanUtils.copyProperties(departmentDtoForm,department);
        departmentRepo.save(department);
    }

    public List<Department> getAllEnabled() {
        return departmentRepo.findAllByEnableTrue();
    }

    public Department getDepartment(long departmentId) {
        return departmentRepo.getOne(departmentId);
    }
}
