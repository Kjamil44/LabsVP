package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String name;
    private String description;
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private List<Student> students;
    @ManyToOne
    private Teacher teacher;
    private Type type;

    public Course(String name, String description, Teacher teacher) {
        this.courseId = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        students = new ArrayList<>();
    }

    public Course() {

    }
}
