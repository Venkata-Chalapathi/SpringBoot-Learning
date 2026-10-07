package in.gvc.AOPIntroductionDemo.service;

import in.gvc.AOPIntroductionDemo.dto.Student;
import in.gvc.AOPIntroductionDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    public StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public String createStudent(Student student){

        studentRepository.save(student);

        LoggingServiceUtil.logEnd("StudentService", "createStudent");

        return "Student Created";
    }

}
