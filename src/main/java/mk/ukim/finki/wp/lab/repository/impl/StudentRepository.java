package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    public Student saveStudent(Student s){
        DataHolder.students.add(s);
        return s;
    }
    public List<Student> findAllStudents(){
        return DataHolder.students;
    }
    public List<Student> findAllByNameOrSurname(String text){
        return DataHolder.students.stream().filter(i -> text.contains(i.getName())||
                text.contains(i.getSurname())).toList();
    }
}
