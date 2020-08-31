package controller;

import bo.StudentBO;
import bo.StudentBOImpl;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"", "/student"})
public class StudentServlet extends HttpServlet {
    StudentBO studentBO = new StudentBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acion = request.getParameter("action");

        if(acion == null){
            acion = "";
        }
        switch (acion) {
            case "create":
                //showCreateForm();
                break;
            case "view":
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                showStudentList(request, response);
        }
    }

    private void showStudentList(HttpServletRequest request, HttpServletResponse response) {
        List<Student> studentList =  studentBO.findAll();
        request.setAttribute("studentListServlet", studentList);
        try {
            request.getRequestDispatcher("/student/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
