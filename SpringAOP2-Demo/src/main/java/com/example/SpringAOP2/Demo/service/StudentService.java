package com.example.SpringAOP2.Demo.service;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public String createStudent() {
        System.out.println("Student saved");

        try {
            throw new RuntimeException("Some Error Occured");
        } catch (RuntimeException ex){

        }
        return "Student Created";
    }
}
