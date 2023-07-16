import jakarta.servlet.ServletException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import java.io.*;

public class UserDashboardServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if the user is authenticated and has the user role
        // if (isUser(request)) {
        request.getRequestDispatcher("User.html").forward(request, response);
        // } else {
        // response.sendRedirect("login.html");
        // }
    }

    /*
     * private boolean isUser(HttpServletRequest request) {
     * HttpSession session = request.getSession(false);
     * return session != null && session.getAttribute("username") != null &&
     * !isAdmin((String) session.getAttribute("username"));
     * }
     * 
     * // Role check logic
     * private boolean isAdmin(String username) {
     * // Implement your role check logic here
     * // Return true if the user is an admin, otherwise false
     * }
     */
}
