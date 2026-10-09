package com.example.SpringAOP2.Demo.service;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public String createStudent() {
        System.out.println("Student saved");

//        try {
//            throw new RuntimeException("Some Error Occured");
//        } catch (RuntimeException ex){
//
//        }
        throw new RuntimeException("Some Error Occured");
//        return "Student Created";
    }

    public String dummyMethod(String s) {

        return s;
    }
}
