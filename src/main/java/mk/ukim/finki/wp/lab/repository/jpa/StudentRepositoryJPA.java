package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepositoryJPA extends JpaRepository<Student,Long> {
    List<Student> findAllByNameOrSurname(String name, String surname);
}
