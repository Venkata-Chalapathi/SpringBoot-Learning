package com.example.SpringAOP2.Demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution (String com.example.SpringAOP2.Demo.service.StudentService.createStudent())")
    public void LogBeforeMethod(JoinPoint joinPoint) {

        joinPoint.getArgs();

        System.out.println("Student is going to be Saved");

//        boolean isAllowed = false;
//
//        if(!isAllowed){
//            throw new RuntimeException("Method Execution is not allowed");
//        }
    }


    @AfterReturning(
            value = "execution (String com.example.SpringAOP2.Demo.service.StudentService.createStudent())",
            returning = "result")
    public void LogAfterReturningMethod(String result) {

//        System.out.println("LogAfterReturningMethod Called");

        System.out.println("Target Method Returned : " + result);
    }
}
