package in.gvc.AOPIntroductionDemo.service;

import in.gvc.AOPIntroductionDemo.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class LoggingDecorator implements StudentService{

    private StudentServiceImpl studentServiceImpl;

    public LoggingDecorator(StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl = studentServiceImpl;
    }

    @Override
    public String createStudent(Student student) {

        LoggingServiceUtil.logStart("StudentServiceImpl", "createStudent");
        studentServiceImpl.createStudent(student);
        LoggingServiceUtil.logEnd("StudentServiceImpl", "createStudent");
        return "Student Created";
    }
}
