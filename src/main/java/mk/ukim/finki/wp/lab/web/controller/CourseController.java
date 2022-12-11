package mk.ukim.finki.wp.lab.web.controller;


import mk.ukim.finki.wp.lab.exceptions.AlreadyAddedCourse;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    private final TeacherService teacherService;
    private final StudentService studentService;

    public CourseController(CourseService courseService, TeacherService teacherService, StudentService studentService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @GetMapping
    public String getCoursesPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        model.addAttribute("courses",courseService.listAll());
        return "listCourses";
    }

    @GetMapping("/add-form")
    public String getAddCoursePage(Model model){
        List<Teacher> teachers = this.teacherService.findAll();
        model.addAttribute("teachers",teachers);
        return "add-course";
    }

    @PostMapping("/add")
    public String saveCourse(@RequestParam String name, @RequestParam String description, @RequestParam Long teacherId){
        try {
            courseService.createCourse(name,description,teacherService.getTeacherByid(teacherId));
        }catch (AlreadyAddedCourse ex){
            ex.getMessage();
        }
        return "redirect:/listCourses";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditCoursesPage(@PathVariable Long id,Model model){
        if(this.courseService.findById(id).isPresent()){
            Course course = courseService.findById(id).get();
            List<Teacher> teachers = this.teacherService.findAll();
            model.addAttribute("teachers",teachers);
            model.addAttribute("course",course);
            return "add-course";
        }
        return "redirect:/course?error=CourseNotFound";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id){
        this.courseService.deleteById(id);
        return "redirect:/listCourses";
    }
}
