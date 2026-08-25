package in.gvc.crudSpringBootDemo.service;

import in.gvc.crudSpringBootDemo.entity.Student;
//import in.gvc.crudSpringBootDemo.entity.Students;
import in.gvc.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        // BUSINESS LOGIC LIKE VALIDATIONS
//        System.out.println("Inside Service");
        Student studentRes = studentRepository.save(studentReq);
//        System.out.println("Exiting Service");
        return studentRes;
    }

    public Student getStudent(long id) {

        Optional<Student> studentResById = studentRepository.findById(id);
        return studentResById.orElse(null);
    }

    public List<Student> getAllStudents() {

        List<Student> studentListResp = studentRepository.findAll();

        if(studentListResp.isEmpty()){
            return null;
        }
        return studentListResp;
    }

    public Student updateStudentById(long id, Student studentReq) {

        Student student = getStudent(id);

        if(student == null){
            return null;
        }

        Student updatedStuById = studentRepository.save(studentReq);
        return updatedStuById;
    }

    public Student deleteStudentByID(long id) {

        Student exstudent = getStudent(id);
        if(exstudent == null){
            return null;
        }
        studentRepository.deleteById(id);
        return exstudent;
    }
}
