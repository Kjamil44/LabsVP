package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.exceptions.AlreadyAddedCourse;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.repository.impl.CourseRepository;
import mk.ukim.finki.wp.lab.repository.impl.StudentRepository;
import mk.ukim.finki.wp.lab.repository.jpa.CourseRepositoryJPA;
import mk.ukim.finki.wp.lab.repository.jpa.StudentRepositoryJPA;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CourseServiceImplement implements CourseService {
    private final CourseRepositoryJPA courseRepository;
    private final StudentRepositoryJPA studentRepository;

    public CourseServiceImplement(CourseRepositoryJPA  courseRepository, StudentRepositoryJPA studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Course> listAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.listStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        var student = studentRepository.findAll().stream().filter(i -> i.getUsername().equals(username))
                .findFirst().get();
        var course = courseRepository.findAll()
                .stream().filter(i -> Objects.equals(i.getCourseId(), courseId)).findFirst().get();
        course = courseRepository.addStudentToCourse(student,course);
        return course;
    }

    @Override
    public void createCourse(String name, String description, Teacher teacher) throws AlreadyAddedCourse {
        courseRepository.save(new Course(name,description,teacher));
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
