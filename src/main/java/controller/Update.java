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

public class Update extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String age = request.getParameter("age");
        String name = request.getParameter("name");
        String bir = request.getParameter("bir");
        java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Integer integer = Integer.valueOf(age);

        Date aa = null;
        try {
            aa = formatter.parse(bir);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        StudentServices studentServices = new StudentServicesImpl();
        Student student = new Student("1", name, integer, aa);
        studentServices.updateStudent(student);
        response.sendRedirect(request.getContextPath() + "/findAll");
    }
}
