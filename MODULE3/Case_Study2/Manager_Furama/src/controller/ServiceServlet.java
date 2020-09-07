package controller;

import bo.serviceBo.ServiceBO;
import bo.serviceBo.ServiceBOImpl;
import model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    ServiceBO serviceBO = new ServiceBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
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
                break;
            default:
                break;
        }
    }

    private void serviceCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("service/service-create.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double area = Double.parseDouble(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentType = Integer.parseInt(request.getParameter("rentType"));
        int typeService = Integer.parseInt(request.getParameter("typeService"));
        if (typeService == 1) {
            String standardRoom = request.getParameter("standardRoom");
            String description = request.getParameter("description");
            double areaPool = Double.parseDouble(request.getParameter("areaPool"));
            int numberFloor = Integer.parseInt(request.getParameter("numberFloor"));
            serviceBO.create(new Service(id, name, area, cost, maxPeople, rentType, typeService, standardRoom, description, areaPool, numberFloor));
        } else if (typeService == 2) {
            String standardRoom = request.getParameter("standardRoom");
            String description = request.getParameter("description");
            int numberFloor = Integer.parseInt(request.getParameter("numberFloor"));
            serviceBO.create(new Service(id, name, area, cost, maxPeople, rentType, typeService, standardRoom, description, numberFloor));
        } else if (typeService == 3) {
            serviceBO.create(new Service(id, name, area, cost, maxPeople, rentType, typeService));
        }
        try {
            response.sendRedirect("/service");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
