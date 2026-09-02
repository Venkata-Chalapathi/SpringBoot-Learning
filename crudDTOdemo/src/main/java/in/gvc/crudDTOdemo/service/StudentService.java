package in.gvc.crudDTOdemo.service;

import in.gvc.crudDTOdemo.entity.Student;
import in.gvc.crudDTOdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    public Student createStudent(Student studentReq) {
        return studentRepository.save(studentReq);
    }
}
