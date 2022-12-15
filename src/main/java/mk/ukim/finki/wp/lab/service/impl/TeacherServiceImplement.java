package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.repository.impl.TeacherRepository;
import mk.ukim.finki.wp.lab.repository.jpa.TeacherRepositoryJPA;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImplement implements TeacherService {

    private final TeacherRepositoryJPA teacherRepository;

    public TeacherServiceImplement(TeacherRepositoryJPA teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherByid(Long teacherId) {
        return teacherRepository.getReferenceById(teacherId);
    }
}
