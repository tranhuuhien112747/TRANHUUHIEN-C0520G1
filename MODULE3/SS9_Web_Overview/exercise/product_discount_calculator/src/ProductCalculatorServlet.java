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

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>DisPlay</h1>");
        writer.println("\n");
        writer.println("<h2> Product Description: " + des + "</h2>");
        writer.println("\n");
        writer.println("<h2>List Price: " + price + "</h2>");
        writer.println("\n");
        writer.println("<h2>Discount Percent: " + discount + "</h2>");
        writer.println("\n");
        writer.println("<h2>Discount Amount: " + amount + "</h2>");
        writer.println("\n");
        writer.println("<h2>Discount Percent</h2>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
