package in.gvc.service;

import in.gvc.entity.Student;
import in.gvc.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent( Student studentReq ){
        return studentRepository.save(studentReq);
    }

    public Student getStudent(Long id){
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

}
