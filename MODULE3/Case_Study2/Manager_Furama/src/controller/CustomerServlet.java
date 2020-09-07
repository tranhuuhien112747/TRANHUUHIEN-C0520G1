package controller;

import bo.customerBo.CustomerBO;
import bo.customerBo.CustomerBoImpl;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerBO customerBO = new CustomerBoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
            case "edit":
                editCustomer(request, response);
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
                createFormCustomer(request, response);
                break;
            case "view":
                showCustomerInformation(request, response);
                break;
            case "delete":
                deleteCustomerForm(request, response);
                break;
            case "edit":
                updateCustomerForm(request, response);
                break;
            case "search":
                customerSearch(request, response);
            default:
                showCustomerList(request, response);
                break;
        }
    }

    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerBO.findAllCustomer();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("customer/customer-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomerInformation(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = customerBO.findById(id);
        if (customer == null) {
            request.setAttribute("message", "Not Found!!!");
        } else {
            request.setAttribute("customer", customer);
        }
        try {
            request.getRequestDispatcher("customer/customer-view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        int type = Integer.parseInt(request.getParameter("typeId"));
        String name = request.getParameter("name");
        Date date = Date.valueOf(request.getParameter("birthday"));
        String gender = request.getParameter("gender");
        String card = request.getParameter("card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, date, gender, card, phone, email, address, type);
        customerBO.create(customer);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFormCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("customer/customer-create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = customerBO.findById(id);
        if (customer == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            request.setAttribute("customer", customer);
        }
        try {
            request.getRequestDispatcher("customer/customer-delete.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = customerBO.findById(id);
        if (customer == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            customerBO.delete(id);
        }
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = customerBO.findById(id);
        if (customer == null) {
            request.setAttribute("message", "Not Found");
        } else {
            request.setAttribute("customer", customer);
        }
        try {
            request.getRequestDispatcher("customer/customer-update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = customerBO.findById(id);
        if (customer == null) {
            request.setAttribute("message", "Not Found");
        } else {
            customer.setCustomerTypeId(Integer.parseInt(request.getParameter("typeId")));
            customer.setCustomerName(request.getParameter("name"));
            customer.setCustomerBirthday(Date.valueOf(request.getParameter("birthday")));
            customer.setCustomerGender((request.getParameter("gender")));
            customer.setCustomerIdCard(request.getParameter("card"));
            customer.setCustomerPhone(request.getParameter("phone"));
            customer.setCustomerEmail(request.getParameter("email"));
            customer.setCustomerAddress(request.getParameter("address"));
            customerBO.update(customer);
            request.setAttribute("customer", customer);
            try {
                response.sendRedirect("/customer");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void customerSearch(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList;
        String value = request.getParameter("search");
        customerList = customerBO.searchName(value);
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("customer/customer-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
