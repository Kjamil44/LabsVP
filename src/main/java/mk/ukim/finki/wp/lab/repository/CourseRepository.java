package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.exceptions.AlreadyAddedCourse;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class CourseRepository {
    public List<Course> findAllCourses(){
        return DataHolder.courses;
    }
    public List<Student> findAllStudentsByCourse(Long courseId){
        var course =  DataHolder.courses.stream().filter(i -> i.getCourseId().equals(courseId)).findFirst();
        return course.get().getStudents();
    }

    public Course addStudentToCourse(Student student, Course course){
        course.getStudents().add(student);
        DataHolder.courses.add(course);
        return course;
    }
    public void createCourse(String name, String description, Teacher teacher) throws AlreadyAddedCourse {
        boolean isAlreadyPresent = DataHolder.courses.stream().anyMatch(i -> Objects.equals(i.getName(), name));
        if(isAlreadyPresent)
            throw new AlreadyAddedCourse("Course with the same name already exists.");
        DataHolder.courses.add(new Course(name,description,teacher));
    }

    public void deleteById(Long Id){
        DataHolder.courses.removeIf(b->b.getCourseId().equals(Id));
    }

    public Optional<Course> findById(Long id){
        return DataHolder.courses.stream().filter(b->b.getCourseId().equals(id)).findFirst();
    }
}
