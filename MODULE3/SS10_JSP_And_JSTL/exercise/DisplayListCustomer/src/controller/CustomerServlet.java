package controller;

import model.Customers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customers> customersList = new ArrayList<>();
        customersList.add(new Customers("Dong Ta", "11/14/1996", "Dao Hoa Dao", "dongta.png"));
        customersList.add(new Customers("Tay Doc", "11/14/1996", "Tay Tang", "taydoc.jpg"));
        customersList.add(new Customers("Nam De", "11/14/1996", "Nam Quoc", "namde.png"));
        customersList.add(new Customers("Bac Cai", "11/14/1996", "Cai Bang", "chubathong.jpg"));
        customersList.add(new Customers("Chu Ba Thong", "11/14/1996", "Co Mo", "baccai.jpg"));
        request.setAttribute("listCustomer", customersList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
