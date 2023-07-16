import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class SessionEx1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h3>" + "Session Example Second Page" + "</h3>");
        HttpSession sess = request.getSession(false);
        /* Display session ID, creation time, and access time. */

        out.println("<p> Session Id: " + sess.getId() + "</p>");
        out.println("<p> Created on this page: " + sess.isNew() + "</p>");
        out.println("<p> Created  Time: " + new Date(sess.getCreationTime()) + "</p>");
        out.println("<p> Last Access Time: " + (sess.getLastAccessedTime()) + "</p>");

        /* Display all attributes. */

        Enumeration<String> names = sess.getAttributeNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = sess.getAttribute(name).toString();

            out.println("<p> " + name + "  :   " + value + "</p>");
        }
    }

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

    }
}
