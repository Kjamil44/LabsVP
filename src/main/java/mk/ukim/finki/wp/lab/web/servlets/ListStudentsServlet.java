package mk.ukim.finki.wp.lab.web.servlets;

import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "listStudent-servlet", urlPatterns = "/AddStudent")
public class ListStudentsServlet extends HttpServlet {
    private final CourseService courseService;
    private final StudentService studentService;
    private final SpringTemplateEngine springTemplateEngine;

    public ListStudentsServlet(CourseService courseService, StudentService studentService, SpringTemplateEngine springTemplateEngine) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("students",studentService.listAll());
        String username = req.getParameter("username");
        req.getSession().setAttribute("username", username);
        this.springTemplateEngine.process("listStudents.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseId = req.getParameter("courseId");
        req.getSession().setAttribute("courseId", courseId);
        resp.sendRedirect("/AddStudent");
    }
}
