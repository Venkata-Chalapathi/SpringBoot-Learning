package in.gvc.crudSpringBootDemo.dto;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDTO {

    @NotBlank(message = "Name cannot be null, empty, ")
    @Size(min = 2, max = 50, message = "student must b ein range 2 - 50 chars")
    private String name;

    @NotBlank(message = "Email cannot be null, empty, ")
    @Email(message = "Incorrect email")
    private String email;

    @NotNull( message = "Age cannot be null")
    @Min(value = 18, message = "Student must be 18 Years")
    private Integer age;

    @NotNull(message = "Roll No cannot be null")
    private Integer rollNo;

    @NotBlank(message = "Subject is required")
    private String subject;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
