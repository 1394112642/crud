package controller;

import entity.Student;
import services.StudentServices;
import services.StudentServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Add extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        Integer integer = Integer.valueOf(age);
        String bir = request.getParameter("bir");
        java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(bir);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Student student = new Student("1", name, integer, date);
        StudentServices studentServices = new StudentServicesImpl();
        studentServices.addStudent(student);
        response.sendRedirect(request.getContextPath() + "/findAll");
    }
}
