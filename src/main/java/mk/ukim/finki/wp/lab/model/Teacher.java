package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    private String name;
    private String surname;

    public Teacher(String name, String surname) {
        this.teacherId = (long) (Math.random() * 1000);
        this.name = name;
        this.surname = surname;
    }

    public Teacher() {

    }
}
