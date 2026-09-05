package in.gvc.filterDemo.service;

import in.gvc.filterDemo.entity.Student;
import in.gvc.filterDemo.repository.StudentRespository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRespository studentRespository;

    public StudentService(StudentRespository studentRespository){
        this.studentRespository = studentRespository;
    }

    public void createStud(Student student) {
        System.out.println("Student Created");
        System.out.println(student.getName());
        System.out.println(student.getEmail());
    }
}
