package mk.ukim.finki.wp.lab.web.servlets;

import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createStudent-servlet",urlPatterns = "/CreateStudent")
public class CreateStudentServlet extends HttpServlet {
    private final StudentService studentService;
    private final SpringTemplateEngine springTemplateEngine;

    public CreateStudentServlet(StudentService studentService, SpringTemplateEngine springTemplateEngine) {
        this.studentService = studentService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        this.springTemplateEngine.process("createStudent.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        studentService.save(username,password,name,surname);
        req.getSession().setAttribute("username",username);
        req.getSession().setAttribute("password",password);
        req.getSession().setAttribute("name",name);
        req.getSession().setAttribute("surname",surname);
        resp.sendRedirect("/AddStudent");
    }
}
