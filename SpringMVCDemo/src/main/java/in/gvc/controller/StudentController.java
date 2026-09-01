package in.gvc.controller;

import in.gvc.entity.Student;
import in.gvc.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;



    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student studentReq){
        Student studentResp = studentService.createStudent(studentReq);
        return ResponseEntity.ok(studentResp);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> findStudById(@PathVariable("id") Long id) {
        Student studentResp = studentService.getStudent(id);

        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }
    @GetMapping()
    public ResponseEntity<List<Student>> findAllStud() {
        List<Student> allStud = studentService.getAllStudent();

        return ResponseEntity.ok(allStud);
    }
}
