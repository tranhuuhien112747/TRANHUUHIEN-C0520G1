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
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewStudent(request,response);
                break;
            default:

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createForm(request,response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            default:
                showListStudent(request, response);
                break;

        }
    }

    private void showListStudent(HttpServletRequest request, HttpServletResponse response) {
        List<Student> studentList = studentBO.findAllStudent();
        request.setAttribute("studentList", studentList);
        try {
            request.getRequestDispatcher("student/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Student student = studentBO.findById(id);
        try {
            studentBO.delete(id);
            List<Student> studentList = studentBO.findAllStudent();
            request.setAttribute("studentList", studentList);
            request.getRequestDispatcher("student/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewStudent(HttpServletRequest request, HttpServletResponse response) {
        Student student = null;
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String type = request.getParameter("typeId");
        try {
            student=new Student(id,name,age,type);
            studentBO.create(student);
           response.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void  createForm(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("student/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void  createForm(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("student/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
