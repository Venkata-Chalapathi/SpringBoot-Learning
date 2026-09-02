package in.gvc.crudDTOdemo.controller;

import in.gvc.crudDTOdemo.entity.Student;
import in.gvc.crudDTOdemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    // CREATE
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student studentResp = studentService.createStudent(student);

        return ResponseEntity.ok(studentResp);
    }
}
