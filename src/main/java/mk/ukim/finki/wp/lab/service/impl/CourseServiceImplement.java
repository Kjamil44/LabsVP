package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.exceptions.AlreadyAddedCourse;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import mk.ukim.finki.wp.lab.repository.StudentRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CourseServiceImplement implements CourseService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseServiceImplement(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Course> listAll() {
        return courseRepository.findAllCourses();
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.findAllStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        var student = studentRepository.findAllStudents().stream().filter(i -> i.getUsername().equals(username))
                .findFirst().get();
        var course = courseRepository.findAllCourses()
                .stream().filter(i -> Objects.equals(i.getCourseId(), courseId)).findFirst().get();
        course = courseRepository.addStudentToCourse(student,course);
        return course;
    }

    @Override
    public void createCourse(String name, String description, Teacher teacher) throws AlreadyAddedCourse {
        courseRepository.createCourse(name,description,teacher);
    }

    @Override
    public void deleteById(Long Id) {
        courseRepository.deleteById(Id);
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }
}
