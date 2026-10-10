package com.example.SpringAOP2.Demo.controller;

import com.example.SpringAOP2.Demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    private StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent() {
        return ResponseEntity.ok(studentService.createStudent());
    }

    @GetMapping
    public ResponseEntity<String> getStudent() {

        String s = "Chala";
        return ResponseEntity.ok(studentService.getStudent(s));
    }
}
