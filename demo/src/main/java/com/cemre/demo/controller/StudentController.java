package com.cemre.demo.controller;

import com.cemre.demo.model.Student;
import com.cemre.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);

    }

    @GetMapping("/list")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
