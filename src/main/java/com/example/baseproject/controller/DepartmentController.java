package com.example.baseproject.controller;

import com.example.baseproject.dto.DepartmentDto;
import com.example.baseproject.entity.Department;
import com.example.baseproject.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/getAllDepartment")
    public String getAllDepartment(Model model) {
        List<Department> departmentList = departmentService.getAllEnabled();
        model.addAttribute("departmentDtoForm", generateDepartmentDtoList(departmentList));
        return "department/allDepartment";
    }

    @GetMapping("/getAddDepartment")
    public String getAddDepartment(Model model) {
        DepartmentDto departmentDto = new DepartmentDto();
        model.addAttribute("departmentDtoForm", departmentDto);
        return "department/addDepartment";
    }

    @PostMapping("/saveDepartment")
    public String saveStudent(@ModelAttribute DepartmentDto departmentDtoForm) {
        departmentService.save(departmentDtoForm);
        return "redirect:/department/getAllDepartment";
    }


    private List<DepartmentDto> generateDepartmentDtoList(List<Department> DepartmentList) {
        List<DepartmentDto> DepartmentDtoList = new ArrayList<>();
        for (Department Department : DepartmentList) {
            DepartmentDto DepartmentDto = new DepartmentDto();
            BeanUtils.copyProperties(Department, DepartmentDto);
            DepartmentDtoList.add(DepartmentDto);
        }
        return DepartmentDtoList;
    }

}
