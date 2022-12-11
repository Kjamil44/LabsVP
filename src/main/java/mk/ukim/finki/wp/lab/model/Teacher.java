package mk.ukim.finki.wp.lab.model;

import lombok.Data;

@Data
public class Teacher {
    private Long teacherId;
    private String name;
    private String surname;

    public Teacher(String name, String surname) {
        this.teacherId = (long) (Math.random() * 1000);
        this.name = name;
        this.surname = surname;
    }
}
