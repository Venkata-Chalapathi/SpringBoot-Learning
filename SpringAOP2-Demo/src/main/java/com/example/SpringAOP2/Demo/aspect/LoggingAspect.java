package com.example.SpringAOP2.Demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Before("execution (String com.example.SpringAOP2.Demo.service.StudentService.createStudent())")
//    public void LogBeforeMethod(JoinPoint joinPoint) {
//
//        joinPoint.getArgs();
//
//        System.out.println("Student is going to be Saved");
//
////        boolean isAllowed = false;
////
////        if(!isAllowed){
////            throw new RuntimeException("Method Execution is not allowed");
////        }
//    }


//    @AfterReturning(
//            value = "execution (String com.example.SpringAOP2.Demo.service.StudentService.createStudent())",
//            returning = "result")
//    public void LogAfterReturningMethod(String result) {
//
////        System.out.println("LogAfterReturningMethod Called");
//
//        System.out.println("Target Method Returned : " + result);
//    }

//    @AfterThrowing(
//            value = "execution (String com.example.SpringAOP2.Demo.service.StudentService.createStudent())"
//            , throwing = "exception")
//    public void LogAfterThrowingMethod( Throwable exception ) {
//        System.out.println("Exception Type : " + exception.getClass().getName());
//        System.out.println("Exception Message : " + exception.getMessage());
//    }

//        @After(
//                value = "execution (String com.example.SpringAOP2.Demo.service.StudentService.createStudent())")
//        public void LogAfterMethod( ) {
//            System.out.println("LogAfterMethod Called");
//        }

//        @Around(
//                value = "execution (String com.example.SpringAOP2.Demo.service.StudentService.createStudent())")
//        public Object LogAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//            System.out.println("Starting Execution");
//
//            try {
//                Object result = (String) joinPoint.proceed();
//
//                System.out.println("Execution successful");
//
//                return result;
//            } catch (Exception e) {
//                System.out.println("Execution failed");
//                throw e;
//
//            } finally {
//                System.out.println("Execution completed");
//            }
//        }

    @Around(
            value = "execution (String com.example.SpringAOP2.Demo.service.StudentService.dummyMethod(..))")
    public Object LogAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] arr = joinPoint.getArgs();

        String orgString = (String) arr[0];

        String newStr = orgString.toUpperCase();

        Object[] modArr = {
                newStr
        };

        return joinPoint.proceed(modArr);
    }
}
