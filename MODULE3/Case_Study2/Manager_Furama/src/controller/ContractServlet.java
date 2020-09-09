package controller;

import bo.contractBo.ContractBO;
import bo.contractBo.ContractBoImpl;
import bo.customerBo.CustomerBO;
import bo.customerBo.CustomerBoImpl;
import bo.employeeBo.EmployeeBO;
import bo.employeeBo.EmployeeBoImpl;
import bo.serviceBo.ServiceBO;
import bo.serviceBo.ServiceBOImpl;
import model.Contract;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    ContractBO contractBO = new ContractBoImpl();
    CustomerBO customerBO=new CustomerBoImpl();
    ServiceBO serviceBO =new ServiceBOImpl();
    EmployeeBO employeeBO =new EmployeeBoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContract(request, response);
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
                contractCreateForm(request, response);
                break;
            case "search":
                searchContract(request, response);
                break;
            default:
                showContractList(request, response);
                break;
        }
    }

    private void showContractList(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = contractBO.findAllContract();
        request.setAttribute("contractList", contractList);
        try {
            request.getRequestDispatcher("contract/contract-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList;
        String value = request.getParameter("search");
        contractList = contractBO.searchName(value);
        request.setAttribute("contractList", contractList);
        try {
            request.getRequestDispatcher("contract/contract-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void contractCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("customerList",customerBO.findAllCustomer());
            request.setAttribute("employeeList",employeeBO.findAllEmployee());
            request.setAttribute("serviceList",serviceBO.findAllService());
            request.getRequestDispatcher("contract/contract-create.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        List<String> messageList;
        Contract contract = null;
        int id = Integer.parseInt(request.getParameter("id"));
        String startDate = request.getParameter("start");
        String endDate = request.getParameter("end");
        String deposit = request.getParameter("deposit");
        String totalMoney = request.getParameter("money");
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String customerId = request.getParameter("customerId");
        String serviceId = request.getParameter("serviceId");
        messageList=contractBO.checkValidateCreateContract(id,deposit, totalMoney);
        if(messageList.isEmpty()){
            contract = new Contract(id, startDate, endDate,Double.parseDouble(deposit) ,Double.parseDouble(totalMoney),employeeId, customerId, serviceId);
            contractBO.create(contract);
            try {
                response.sendRedirect("/contract");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("message",messageList);
            try {
                request.setAttribute("customerList",customerBO.findAllCustomer());
                request.setAttribute("employeeList",employeeBO.findAllEmployee());
                request.setAttribute("serviceList",serviceBO.findAllService());
                request.getRequestDispatcher("contract/contract-create.jsp").forward(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }

    }
}
