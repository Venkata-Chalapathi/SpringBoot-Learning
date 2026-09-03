package in.gvc.crudSpringBootDemo.controller;


import in.gvc.crudSpringBootDemo.dto.CreateStudentRequestDTO;
import in.gvc.crudSpringBootDemo.dto.CreateStudentResponseDTO;
import in.gvc.crudSpringBootDemo.dto.UpdateStudRequestDTO;
import in.gvc.crudSpringBootDemo.dto.UpdateStudResponseDTO;
import in.gvc.crudSpringBootDemo.entity.Student;
import in.gvc.crudSpringBootDemo.service.StudentService;
import jakarta.validation.Valid;
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

    @PostMapping
    public ResponseEntity<CreateStudentResponseDTO> createStudent(@Valid @RequestBody CreateStudentRequestDTO createStudentRequestDTO) {
        // LISTEN TO HTTP REQUESTS
//        System.out.println("Inside Controller");
//        studentRequestDTO.setDeleted(false);
        CreateStudentResponseDTO createdStudent = studentService.createStudent(createStudentRequestDTO);
//        System.out.println("Exiting Controller");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

        // READ ONE STUDENT

    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDTO> getStudentById(@PathVariable long id){
        CreateStudentResponseDTO studentResbyId = studentService.getStudent(id);
//        if(studentResbyId != null){
//            return ResponseEntity.ok(studentResbyId);
//        }
        return ResponseEntity
                .ok(studentResbyId);
    }

    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDTO>> getAllStudents() {

        List<CreateStudentResponseDTO> studentsListResp = studentService.getAllStudents();

//        if(studentsListResp.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
        return ResponseEntity.ok(studentsListResp);
    }

    @PutMapping
    public ResponseEntity<UpdateStudResponseDTO> updateStuById(@RequestParam long id, @RequestBody UpdateStudRequestDTO updateStudRequestDTO) {

        UpdateStudResponseDTO updateStuResp = studentService.updateStudentById(id, updateStudRequestDTO);

//        if(updateStuResp == null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
        return ResponseEntity.ok(updateStuResp);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteById(@RequestParam long id) {

        /* Student deletedStudent  = */ studentService.deleteStudentByID(id);

//        if(deletedStudent == null){
//            return ResponseEntity.notFound().build();
//        }

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteSoftlyById(@RequestParam long id){

        /* Boolean isDeleted = */ studentService.deleteStudentSoftlyById(id);

//        if(!isDeleted){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok("Record Deleted Softly");

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
