import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import java.io.*;

public class ErrorPageServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>heeloo error!!!1</title><head><body>ERROR!!!!!!!!!1</body></html>");
        out.close();
    }

}
