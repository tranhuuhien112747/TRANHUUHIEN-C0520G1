package controller;

import bo.employeeBo.EmployeeBO;
import bo.employeeBo.EmployeeBoImpl;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeBO employeeBO = new EmployeeBoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewEmployee(request, response);
                break;
            case "delete":
//                deleteEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
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
                createFormEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            case "edit":
                updateEmployeeForm(request, response);
                break;
            case "search":
                employeeSearch(request, response);
                break;
            case "view":
                showInformationEmployee(request, response);
                break;
            default:
                showEmployeeList(request, response);
                break;
        }
    }

    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeBO.findAllEmployee();
        request.setAttribute("employeeList", employeeList);
        try {
            request.getRequestDispatcher("employee/employee-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showInformationEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeBO.findById(id);
        if (employee == null) {
            request.setAttribute("message", "Not Found");
        } else {
            request.setAttribute("employee", employee);
        }
        try {
            request.getRequestDispatcher("employee/employee-view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<String> messageList = new ArrayList<>();
        Employee employee = null;
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String date = request.getParameter("birthday");
        String card = request.getParameter("card");
        String salary = request.getParameter("salary");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int division = Integer.parseInt(request.getParameter("division"));
        int education = Integer.parseInt(request.getParameter("education"));
        String user = request.getParameter("user");
        messageList = employeeBO.checkValidateCreateEmployee(id, card, salary, phone, email);
        if (messageList.isEmpty()) {
            employee = new Employee(id, name, date, card, Double.parseDouble(salary), phone, email, address, position, division, education, user);
            employeeBO.create(employee);
            try {
                response.sendRedirect("/employee");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("message", messageList);
            try {
                request.getRequestDispatcher("employee/employee-create.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createFormEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("employee/employee-create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void deleteEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Employee employee = employeeBO.findById(id);
//        if (employee == null) {
//            request.setAttribute("message", "Not Found !!!");
//        } else {
//            request.setAttribute("employee", employee);
//        }
//        try {
//            request.getRequestDispatcher("employee/employee-delete.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeBO.findById(id);
        if (employee == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            employeeBO.delete(id);
            List<Employee> employeeList = employeeBO.findAllEmployee();
            request.setAttribute("employeeList", employeeList);
        }
        try {
            request.getRequestDispatcher("employee/employee-list.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void updateEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeBO.findById(id);
        if (employee == null) {
            request.setAttribute("message", "Not Found");
        } else {
            request.setAttribute("employee", employee);
        }
        try {
            request.getRequestDispatcher("employee/employee-update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<String> messageList = new ArrayList<>();
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeBO.findById(id);
        if (employee == null) {
            request.setAttribute("message", "Not Found");
        } else {
            employee.setEmployeeId(Integer.parseInt(request.getParameter("id")));
            employee.setEmployeeName(request.getParameter("name"));
            employee.setEmployeeBirthday(request.getParameter("birthday"));
            employee.setEmployeeIdCard(request.getParameter("card"));
            employee.setEmployeeSalary(Double.parseDouble(request.getParameter("salary")));
            employee.setEmployeePhone(request.getParameter("phone"));
            employee.setEmployeeEmail(request.getParameter("email"));
            employee.setEmployeeAddress(request.getParameter("address"));
            employee.setEmployeePosition(Integer.parseInt(request.getParameter("position")));
            employee.setEmployeeDivision(Integer.parseInt(request.getParameter("division")));
            employee.setEmployeeEducation(Integer.parseInt(request.getParameter("education")));
            messageList = employeeBO.checkValidateEditEmployee(employee.getEmployeeIdCard(), String.valueOf(employee.getEmployeeSalary()),
                    employee.getEmployeePhone(), employee.getEmployeeEmail());
            if (messageList.isEmpty()) {
                employeeBO.update(employee);
                request.setAttribute("employee", employee);
                try {
                    response.sendRedirect("/employee");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                request.setAttribute("message", messageList);
                request.setAttribute("employee", employee);
                try {
                    request.getRequestDispatcher("employee/employee-update.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void employeeSearch(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList;
        String value = request.getParameter("search");
        employeeList = employeeBO.searchName(value);
        request.setAttribute("employeeList", employeeList);
        try {
            request.getRequestDispatcher("employee/employee-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
