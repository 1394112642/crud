package controller;

import services.StudentServices;
import services.StudentServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Remove extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        StudentServices studentServices = new StudentServicesImpl();
        studentServices.removeStudent(id);
        response.sendRedirect(request.getContextPath() + "/findAll");
    }
}
