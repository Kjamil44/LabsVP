package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.exceptions.AlreadyAddedCourse;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CourseService{
    List<Course> listAll();
    List<Student> listStudentsByCourse(Long courseId);
    Course addStudentInCourse(String username, Long courseId);
    void createCourse(String name, String description, Teacher teacher) throws AlreadyAddedCourse;
    void deleteById(Long Id);
    Optional<Course> findById(Long id);

}