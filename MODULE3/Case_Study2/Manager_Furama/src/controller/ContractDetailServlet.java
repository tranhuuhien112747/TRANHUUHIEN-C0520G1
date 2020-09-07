package controller;

import bo.contractBo.ContractBO;
import bo.contractBo.ContractBoImpl;
import bo.contractDetailBo.ContractDetailBO;
import bo.contractDetailBo.ContractDetailBOImpl;
import model.Contract;
import model.ContractDetail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet", urlPatterns = "/contractDetail")
public class ContractDetailServlet extends HttpServlet {
    ContractDetailBO contractDetailBO = new ContractDetailBOImpl();
    ContractBO contractBO = new ContractBoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContractDetail(request, response);
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
                createContractDetailForm(request, response);
                break;
            default:
                showContractDetail(request,response);
                break;
        }
    }

    private void showContractDetail(HttpServletRequest request, HttpServletResponse response) {
        List<ContractDetail>contractDetailList=contractDetailBO.findAllContractDetail();
        request.setAttribute("contractDetailList", contractDetailList);
        try {
            request.getRequestDispatcher("contractDetail/contractDetail-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createContractDetailForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("contractList", contractBO.findAllContract());
            request.getRequestDispatcher("contractDetail/contractDetail-create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int contractDetailID = Integer.parseInt(request.getParameter("id"));
        int contractId = Integer.parseInt(request.getParameter("contractID"));
        int attachServiceId = Integer.parseInt(request.getParameter("attach"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail = new ContractDetail(contractDetailID, contractId, attachServiceId, quantity);
        contractDetailBO.create(contractDetail);
        try {
            response.sendRedirect("/contractDetail");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
