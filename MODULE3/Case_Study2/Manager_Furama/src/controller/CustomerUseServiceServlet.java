package controller;

import bo.customerUserServiceBo.CustomerUserServiceBO;
import bo.customerUserServiceBo.CustomerUserServiceBOImpl;
import bo.serviceBo.ServiceBO;
import bo.serviceBo.ServiceBOImpl;
import model.CustomerUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerUseServiceServlet", urlPatterns = "/userService")
public class CustomerUseServiceServlet extends HttpServlet {
    CustomerUserServiceBO userServiceBO = new CustomerUserServiceBOImpl();
    ServiceBO serviceBO = new ServiceBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
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
            case "search":
//                request.getRequestDispatcher("service/service-list.jsp").forward(request, response);
            default:
                showListCustomerUseService(request, response);
                break;
        }
    }

    private void showListCustomerUseService(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerUserService> userServiceList = userServiceBO.findAllCustomerUserService();
        request.setAttribute("userServiceList", userServiceList);
        request.setAttribute("service", serviceBO.findAllService());
        try {
            request.getRequestDispatcher("customer-user-service/customer-use-service-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
