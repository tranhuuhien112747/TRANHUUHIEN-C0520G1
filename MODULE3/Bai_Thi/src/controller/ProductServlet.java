package controller;

import bo.ProductBO;
import bo.ProductBOImpl;
import modle.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"", "/product"})
public class ProductServlet extends HttpServlet {
    ProductBO productBO = new ProductBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewProduct(request, response);
                break;
            case "edit":
                editProduct(request,response);
                break;
            default:

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
            case "edit":
                updateProductForm(request,response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "search":
                productSearch(request, response);
                break;
            default:
                showListProduct(request, response);
                break;

        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productBO.findAllProduct();
        request.setAttribute("productList", productList);
        try {
            request.getRequestDispatcher("product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productBO.findById(id);
        try {
            productBO.delete(id);
            List<Product> productList = productBO.findAllProduct();
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewProduct(HttpServletRequest request, HttpServletResponse response) {
        Product product = null;
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int category = Integer.parseInt(request.getParameter("category"));
        try {
            product = new Product(id, name, price, quantity, color, description, category);
            productBO.create(product);
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("product/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void productSearch(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList;
        String value = request.getParameter("search");
        productList = productBO.searchName(value);
        request.setAttribute("productList", productList);
        try {
            request.getRequestDispatcher("product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProductForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productBO.findById(id);
        request.setAttribute("product", product);
        try {
            request.setAttribute("categoryList",productBO.findAll());
            request.getRequestDispatcher("product/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productBO.findById(id);
        product.setName(request.getParameter("name"));
        product.setPrice(Double.parseDouble(request.getParameter("price")));
        product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        product.setColor(request.getParameter("color"));
        product.setDescription(request.getParameter("description"));
        product.setCategory(Integer.parseInt(request.getParameter("category")));
        try {
            productBO.update(product);
            request.setAttribute("product",product);
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


