package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepositoryJPA extends JpaRepository<Course,Long> {
    Course addStudentToCourse(Student student, Course course);
    List<Student> listStudentsByCourse(Long courseId);
}
