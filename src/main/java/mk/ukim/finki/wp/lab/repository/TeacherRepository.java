package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class TeacherRepository {
    public List<Teacher> findAll(){
        return DataHolder.teachers;
    }

    public Teacher getTeacherById(Long teacherId){
        return DataHolder.teachers.stream()
                .filter(i -> Objects.equals(i.getTeacherId(), teacherId))
                .findFirst().get();
    }
}
