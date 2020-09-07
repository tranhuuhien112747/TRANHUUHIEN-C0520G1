package controller;

import bo.serviceBo.ServiceBO;
import bo.serviceBo.ServiceBOImpl;
import model.Employee;
import model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
                createService(request,response);
                break;
            case "delete":
                deleteService(request,response);
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
                serviceCreateForm(request,response);
                break;
            case "delete":
                deleteServiceForm(request,response);
                break;
            case"search":
                serviceSearch(request,response);
                break;
            case "view":
                showInformationService(request,response);
            default:
                showServiceList(request,response);
                break;
        }
    }

    private void showServiceList(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = serviceBO.findAllService();
        request.setAttribute("serviceList", serviceList);
        try {
            request.getRequestDispatcher("service/service-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showInformationService(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Service service =serviceBO.findById(id);
        if (service == null) {
            request.setAttribute("message", "Not Found");
        } else {
            request.setAttribute("service", service);
        }
        try {
            request.getRequestDispatcher("service/service-view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void serviceCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("service/service-create.jsp").forward(request,response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
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
    private void deleteServiceForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Service service =serviceBO.findById(id);
        if (service == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            request.setAttribute("service", service);
        }
        try {
            request.getRequestDispatcher("service/service-delete.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Service service =serviceBO.findById(id);
        if (service== null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            serviceBO.delete(id);
        }
        try {
            response.sendRedirect("/service");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void serviceSearch(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList;
        String value = request.getParameter("search");
        serviceList = serviceBO.searchName(value);
        request.setAttribute("serviceList", serviceList);
        try {
            request.getRequestDispatcher("service/service-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
