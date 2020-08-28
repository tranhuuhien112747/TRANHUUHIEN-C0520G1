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
        customersList.add(new Customers("Dong Ta", "11/14/1996", "Dao Hoa Dao", "web/image/dongta.png"));
        customersList.add(new Customers("Tay Doc", "11/14/1996", "Tay Tang", "web/image/taydoc.jpg"));
        customersList.add(new Customers("Nam De", "11/14/1996", "Nam Quoc", "web/image/namde.png"));
        customersList.add(new Customers("Bac Cai", "11/14/1996", "Cai Bang", "web/image/chubathong.jpg"));
        customersList.add(new Customers("Chu Ba Thong", "11/14/1996", "Co Mo", "web/image/baccai.jpg"));
        request.setAttribute("listCustomer", customersList);
        request.getRequestDispatcher("customerlist/customer.jsp").forward(request, response);
    }
}
