package controller;

import bo.UserBo;
import bo.UserBoImplement;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserManagerServlet", urlPatterns = {"", "/user"})
public class UserManagerServlet extends HttpServlet {
    private UserBo userBo = new UserBoImplement();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewUser(request, response);
                break;
            case "update":
                editUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createForm(request, response);
                break;
            case "update":
                updateEdit(request, response);
                break;
            case "delete":
                deleteForm(request, response);
                break;
//            case "view":
//                viewUser(request, response);
//                break;
//            case "search":
//                searchNameUser(request, response);
//                break;
//            case "sort":
//                sortListProduct(request, response);
            default:
                showListProduct(request, response);
                break;

        }
    }


    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userBo.findAll();
        request.setAttribute("list", userList);
        try {
            request.getRequestDispatcher("user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void createNewUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("fullname");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id, name, email, country);
        userBo.create(user);
        try {
            response.sendRedirect("/user");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("user/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("fullname");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = userBo.findById(id);
        if (user == null) {
            request.setAttribute("message", "File Not Found");
        } else {
            user.setName(name);
            user.setEmail(email);
            user.setCountry(country);
            userBo.update(user);
            request.setAttribute("user", user);
        }
        try {
            response.sendRedirect("/user");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //
    private void updateEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userBo.findById(id);
        if (user == null) {
            request.setAttribute("message", "File Not Found");
        } else {
            request.setAttribute("user", user);
        }
        try {
            request.getRequestDispatcher("user/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userBo.findById(id);
        if (user == null) {
            request.setAttribute("message", "File Not Found");
        } else {
            userBo.delete(id);
            request.setAttribute("message", "Delete " + user.getName() + " Success!!");
        }
        try {
            response.sendRedirect("/user");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userBo.findById(id);
        if (user == null) {
            request.setAttribute("message", "File Not Found");
        } else {
            request.setAttribute("user", user);
        }
        try {
            request.getRequestDispatcher("user/delete.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
