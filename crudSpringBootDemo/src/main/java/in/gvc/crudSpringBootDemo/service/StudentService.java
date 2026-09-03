package in.gvc.crudSpringBootDemo.service;

import in.gvc.crudSpringBootDemo.dto.CreateStudentRequestDTO;
import in.gvc.crudSpringBootDemo.dto.CreateStudentResponseDTO;
import in.gvc.crudSpringBootDemo.dto.UpdateStudRequestDTO;
import in.gvc.crudSpringBootDemo.dto.UpdateStudResponseDTO;
import in.gvc.crudSpringBootDemo.entity.Student;
//import in.gvc.crudSpringBootDemo.entity.Students;
import in.gvc.crudSpringBootDemo.exception.DuplicateResourceException;
import in.gvc.crudSpringBootDemo.exception.ResourceNotFoundException;
import in.gvc.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO createStudentRequestDTO) {
        // BUSINESS LOGIC LIKE VALIDATIONS
//        System.out.println("Inside Service");
//        Student studentRes = studentRepository.save(studentRequestDTO);
//        System.out.println("Exiting Service");
//        return studentRes;

        Student student = mapTOEntity(createStudentRequestDTO);

        if(emailExists(student)){
            throw new DuplicateResourceException("Student with email " + student.getEmail() +
                    " already exists");
        }

        Student studentResp = studentRepository.save(student);

        return mapTODto(studentResp);

    }


    public CreateStudentResponseDTO getStudent(long id) {

//        Optional<Student> studentResById = studentRepository.findByIdAndIsDeletedFalse(id);
//
//        if(studentResById.isEmpty()){
//            return mapTODto(studentResById.get());
//        }
//        return null;

        // After Exceptional handling

        Student studentResp = studentRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow( () -> new ResourceNotFoundException
                        ("Student with id : " + id + " not found"));

        return mapTODto(studentResp);
    }

    public List<CreateStudentResponseDTO> getAllStudents() {

        List<Student> studentListResp = studentRepository.findByIsDeletedFalse();

//        if(studentListResp.isEmpty()){
//            return null;
//        }
        return studentListResp.stream()
                .map(this::mapTODto).toList();
    }

    public UpdateStudResponseDTO updateStudentById(long id, UpdateStudRequestDTO updateStudRequestDTO) {

        Student existingStud =
                studentRepository.findByIdAndIsDeletedFalse(id)
                        .orElseThrow( () ->  new ResourceNotFoundException("Student with id : " + id + " not found"));

//        if(existingStud.isEmpty()){
//            return null;
//        }

//        Student studToSave = existingStud.get();

        existingStud.setName(updateStudRequestDTO.getName());
        existingStud.setAge(updateStudRequestDTO.getAge());
        existingStud.setRollNo(updateStudRequestDTO.getRollNo());
        existingStud.setSubject(updateStudRequestDTO.getSubject());
        existingStud.setUpdatedAt(LocalDateTime.now());

        Student savedStud = studentRepository.save(existingStud);

        return mapToUpdateDTO(savedStud);
    }



    public void deleteStudentByID(long id) {

        Student studentToBeDel =
                studentRepository.findById(id)
                        .orElseThrow( () ->
                                new ResourceNotFoundException("Student with id : " + id + " not found"));

//        if (existingStudent.isEmpty()) {
//            return null;
//        }

//        Student student = existingStudent.get();

        studentRepository.delete(studentToBeDel);
    }

    public void deleteStudentSoftlyById(long id) {
        // 1 = GET
//        Optional<Student> exisStudent = studentRepository.findByIdAndIsDeletedFalse(id);
        Student studentToBeDel =
                studentRepository.findByIdAndIsDeletedFalse(id)
                        .orElseThrow( () ->
                                new ResourceNotFoundException("Student with id : " + id + " not found"));

//        if(exisStudent.isEmpty()){
//            return false;
//        }

//        Student studentToSave = exisStudent.get();
//        studentToSave.setDeleted(true);

        studentToBeDel.setDeleted(true);

        studentRepository.save(studentToBeDel);
//        return true;
    }

    private Student mapTOEntity(CreateStudentRequestDTO createStudentRequestDTO) {

        Student student = new Student();

        student.setName(createStudentRequestDTO.getName());
        student.setAge(createStudentRequestDTO.getAge());
        student.setEmail(createStudentRequestDTO.getEmail());
        student.setRollNo(createStudentRequestDTO.getRollNo());
        student.setSubject(createStudentRequestDTO.getSubject());
        student.setDeleted(false);

        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private CreateStudentResponseDTO mapTODto(Student studentResp) {

        CreateStudentResponseDTO createStudentResponseDTO = new CreateStudentResponseDTO();

        createStudentResponseDTO.setId(studentResp.getId());
        createStudentResponseDTO.setName(studentResp.getName());
        createStudentResponseDTO.setAge(studentResp.getAge());
        createStudentResponseDTO.setEmail(studentResp.getEmail());
        createStudentResponseDTO.setSubject(studentResp.getSubject());
        createStudentResponseDTO.setRollNo(studentResp.getRollNo());
        createStudentResponseDTO.setMessage("Student Saved Successfully");
        createStudentResponseDTO.setCreatedAt(studentResp.getCreatedAt());
        createStudentResponseDTO.setUpdatedAt(studentResp.getUpdatedAt());

        return createStudentResponseDTO;
    }

    private UpdateStudResponseDTO mapToUpdateDTO(Student studentResp) {

        UpdateStudResponseDTO updateStudResponseDTO = new UpdateStudResponseDTO();

        updateStudResponseDTO.setName(studentResp.getName());
        updateStudResponseDTO.setAge(studentResp.getAge());
        updateStudResponseDTO.setEmail(studentResp.getEmail());
        updateStudResponseDTO.setSubject(studentResp.getSubject());
        updateStudResponseDTO.setRollNo(studentResp.getRollNo());
        updateStudResponseDTO.setMessage("Student Updated Successfully");
        updateStudResponseDTO.setUpdatedAt(studentResp.getUpdatedAt());

        return updateStudResponseDTO;
    }

    private boolean emailExists(Student student) {

        return studentRepository.existsByEmail(student.getEmail());
    }

}
