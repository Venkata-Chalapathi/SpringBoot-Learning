package in.gvc.filterDemo.controller;

import in.gvc.filterDemo.entity.Student;
import in.gvc.filterDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.createStud(student);
        return ResponseEntity.ok("Student Created");
    }
}
