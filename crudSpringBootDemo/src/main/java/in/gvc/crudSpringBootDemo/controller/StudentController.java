package in.gvc.crudSpringBootDemo.controller;


import in.gvc.crudSpringBootDemo.entity.Student;
import in.gvc.crudSpringBootDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController (StudentService studentService){
        this.studentService = studentService;
    }

    // CREATE STUDENT

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        // LISTEN TO HTTP REQUESTS
//        System.out.println("Inside Controller");
        student.setDeleted(false);
        Student createdStudent = studentService.createStudent(student);
//        System.out.println("Exiting Controller");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

        // READ ONE STUDENT

    @GetMapping("/get")
    public ResponseEntity<Student> getStudentById(@RequestParam long id){
        Student studentResbyId = studentService.getStudent(id);
        if(studentResbyId != null){
            return ResponseEntity.ok(studentResbyId);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents() {

        List<Student> studentsListResp = studentService.getAllStudents();

        if(studentsListResp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(studentsListResp);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStuById(@RequestParam long id, @RequestBody Student studentReq) {

        Student updateStuResp = studentService.updateStudentById(id, studentReq);

        if(updateStuResp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(updateStuResp);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Student> deleteById(@RequestParam long id) {

        Student deletedStudent = studentService.deleteStudentByID(id);

        if(deletedStudent == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(deletedStudent);
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteSoftlyById(@RequestParam long id){

        Boolean isDeleted = studentService.deleteStudentSoftlyById(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted Softly");
    }
}
