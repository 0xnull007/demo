import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class getInfo extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        ServletConfig sc = getServletConfig();
        Enumeration<String> parameterNames = sc.getInitParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String paramValue = sc.getInitParameter(paramName);
            out.println("<h3>" + paramName + " :     " + paramValue + "</h3>");
        }

        ServletContext servCon = getServletContext();
        Enumeration<String> e = servCon.getInitParameterNames();
        while (e.hasMoreElements()) {
            String n = e.nextElement();
            String v = servCon.getInitParameter(n);
            out.println("<h3>" + n + " :     " + v + "</h3>");
        }

        out.close();
    }
}