package in.gvc.crudSpringBootDemo.repository;

import in.gvc.crudSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByIdAndIsDeletedFalse(long id);

    List<Student> findByIsDeletedFalse();

    Boolean existsByEmail(String email);
}
