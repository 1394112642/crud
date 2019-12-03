package controller;

import entity.Student;
import services.StudentServices;
import services.StudentServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class FindAll extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StudentServices studentServices = new StudentServicesImpl();
        List<Student> students = studentServices.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("students", students);
        response.sendRedirect(request.getContextPath() + "/view/findAll.jsp");
    }
}
