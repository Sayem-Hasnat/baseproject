package com.example.baseproject.controller;

import com.example.baseproject.dto.DepartmentDto;
import com.example.baseproject.dto.StudentDto;
import com.example.baseproject.entity.Department;
import com.example.baseproject.entity.Student;
import com.example.baseproject.service.DepartmentService;
import com.example.baseproject.service.StudentService;
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
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final DepartmentService departmentService;

    public StudentController(StudentService studentService, DepartmentService departmentService) {
        this.studentService = studentService;
        this.departmentService = departmentService;
    }

    @GetMapping("/getAllStudent")
    public String getAllStudent(Model model) {
        List<Student> studentList = studentService.getAllEnabled();
        model.addAttribute("studentDtoList", generateStudentDtoList(studentList));

        return "student/allStudent";
    }

    @GetMapping("/getAddStudent")
    public String getAddStudent(Model model) {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("studentDtoForm", studentDto);
        model.addAttribute("genderList", getGenderList());
        model.addAttribute("departmentListDto", departmentService.getAllEnabled());
        return "student/addStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute StudentDto studentDtoForm) {
        Department department = departmentService.getDepartment(studentDtoForm.getDepartmentDto().getDepartmentId());
        Student student = new Student();
        BeanUtils.copyProperties(studentDtoForm, student);
        student.setDepartment(department);

        studentService.save(student);
        return "redirect:/student/getAllStudent";
    }

    // Helper Method
    private List<StudentDto> generateStudentDtoList(List<Student> StudentList) {
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student student : StudentList) {
            StudentDto studentDto = new StudentDto();
            BeanUtils.copyProperties(student, studentDto);


            //department to departmentDto conversion
            DepartmentDto departmentDto = new DepartmentDto();
            BeanUtils.copyProperties(student.getDepartment(),departmentDto);
            studentDto.setDepartmentDto(departmentDto);

            studentDtoList.add(studentDto);


        }
        return studentDtoList;
    }

    private List<String> getGenderList() {
        List<String> genderList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");
        return genderList;
    }


}


