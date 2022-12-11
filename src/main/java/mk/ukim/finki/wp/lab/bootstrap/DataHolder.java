package mk.ukim.finki.wp.lab.bootstrap;

import lombok.Getter;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Course> courses = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();
    public static List<Teacher> teachers = new ArrayList<>();

    @PostConstruct
    public void init() {
        teachers.add(new Teacher("Mary","Anna"));
        teachers.add(new Teacher("Terry","Anne"));
        teachers.add(new Teacher("Filip","Nekoj"));
        teachers.add(new Teacher("John","Smith"));
        teachers.add(new Teacher("Peter","Parker"));

        courses.add(new Course("Veb programinje", "Mateika nesto",teachers.get(0)));
        courses.add(new Course("Operativni sistemi", "Matemka nesto", teachers.get(1)));
        courses.add(new Course("E mobilna trgovija", "Mata nesto",teachers.get(2)));
        courses.add(new Course("Kompjuterska trgovija", "Matemika nesto",teachers.get(3)));
        courses.add(new Course("Kalkulus", "Matematito",teachers.get(4)));

        students.add(new Student("stefan","student1","Stefan","Stefanovski"));
        students.add(new Student("nikola","student2","Nikola","Stefski"));
        students.add(new Student("petar","student3","Petar","Stojanov"));
        students.add(new Student("goran","student4","Goran","Trajkovski"));
        students.add(new Student("milan","student5","Milan","Dimkoski"));
    }
}
