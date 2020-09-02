package controller;

import bo.StudentBO;
import bo.StudentBOImpl;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"", "/student"})
public class StudentServlet extends HttpServlet {
    private StudentBO studentBO = new StudentBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStudent(request, response);
                break;
            case "update":
                updateStudent(request, response);
                break;
            case "transfer":
                transferMoney(request, response);
                break;
            default:
                showListStudent(request, response);
        }
    }

    private void transferMoney(HttpServletRequest request, HttpServletResponse response) {
        int idStudentFrom = Integer.parseInt(request.getParameter("fromStudent"));
        int idStudentTo = Integer.parseInt(request.getParameter("toStudent"));
        Long money = Long.parseLong(request.getParameter("money"));
        studentBO.transferMoney(idStudentFrom,idStudentTo, money);
        showListStudent(request, response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("studentId"));
        String name = request.getParameter("studentName");
        String address = request.getParameter("studentAddress");

        studentBO.update(new Student(id, name, address));

        showListStudent(request, response);
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("studentName");
        String address = request.getParameter("studentAddress");

        Student student = new Student(name, address);
        studentBO.save(student);

        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/student/complete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                break;
            case "delete":
                break;
            case "transfer":
                showTransferForm(request, response);
                break;
            default:
                showListStudent(request, response);
        }
    }

    private void showTransferForm(HttpServletRequest request, HttpServletResponse response) {
        List<Student> studentList = studentBO.findAll();
        request.setAttribute("studentList", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/student/transfer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentBO.findById(id);

        request.setAttribute("student", student);
        try {
            request.getRequestDispatcher("/student/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showListStudent(HttpServletRequest request, HttpServletResponse response) {
        List<Student> studentList = studentBO.findAll();
        request.setAttribute("studentListServlet", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/student/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("student/create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
