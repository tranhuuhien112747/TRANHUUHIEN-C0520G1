import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductCalculatorServlet", urlPatterns = "/calculator")
public class ProductCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String des = request.getParameter("description");
        double price = Float.parseFloat(request.getParameter("price"));
        double discount = Float.parseFloat(request.getParameter("discount"));

        double amount = price * discount * 0.01;
        request.setAttribute("amount",amount);
        request.setAttribute("des",des);
        request.setAttribute("discount",discount);
        request.setAttribute("price",price);
        request.getRequestDispatcher("result.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
