package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.impl.StudentRepository;
import mk.ukim.finki.wp.lab.repository.jpa.StudentRepositoryJPA;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplement implements StudentService {
    private final StudentRepositoryJPA studentRepository;

    public StudentServiceImplement(StudentRepositoryJPA studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> searchByNameOrSurname(String text) {
        return studentRepository.findAllByNameOrSurname(text,text);
    }

    @Override
    public Student save(String username, String password, String name, String surname) {
        return studentRepository.save(new Student(username, password, name, surname));
    }
}
