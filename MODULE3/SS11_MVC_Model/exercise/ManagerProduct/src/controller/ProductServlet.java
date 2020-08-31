package controller;

import bo.ProductBo;
import bo.ProductBoImplement;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private ProductBo productBo = new ProductBoImplement();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewProduct(request, response);
                break;
            case "update":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
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
                createForm(request, response);
                break;
            case "update":
                updateEdit(request, response);
                break;
            case "delete":
                deleteForm(request, response);
                break;
            case "view":
                viewProduct(request, response);
                break;
            case "search":
                searchNameProduct(request, response);
                break;
            default:
                showListProduct(request, response);
                break;

        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productBo.findAll();
        request.setAttribute("list", productList);
        try {
            request.getRequestDispatcher("product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = productBo.findById(id);
        if (product == null) {
            request.setAttribute("message", "File Not Found");
        } else {
            request.setAttribute("product", product);
        }
        try {
            request.getRequestDispatcher("product/view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        Product product = new Product(id, name, price, description, producer);
        productBo.create(product);
        try {
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

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        Product product = productBo.findById(id);
        if (product == null) {
            request.setAttribute("message", "File Not Found");
        } else {
            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);
            product.setProducer(producer);
            request.setAttribute("product", product);
        }
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateEdit(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = productBo.findById(id);
        if (product == null) {
            request.setAttribute("message", "File Not Found");
        } else {
            request.setAttribute("product", product);
        }
        try {
            request.getRequestDispatcher("product/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchNameProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = new ArrayList<>();
        String name = request.getParameter("search");
        for (Product product : productBo.findAll()) {
            if (product.getName().contains(name)) {
                productList.add(product);
            }
        }
        if (!productList.isEmpty()) {
            request.setAttribute("list", productList);
        } else {
            request.setAttribute("message", "File Not Found");
        }
        try {
            request.getRequestDispatcher("product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = productBo.findById(id);
        if (product == null) {
            request.setAttribute("message", "File Not Found");
        } else {
            productBo.delete(id);
            request.setAttribute("message", "Delete " + product.getName() + " Success!!");
        }
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Product product = productBo.findById(id);
        if (product == null) {
            request.setAttribute("message", "File Not Found");
        } else {
            request.setAttribute("product", product);
        }
        try {
            request.getRequestDispatcher("product/delete.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
