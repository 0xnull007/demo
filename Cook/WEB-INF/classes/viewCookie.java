import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class viewCookie extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        Cookie[] cookies = req.getCookies();

        out.println("<html><body>");
        String name;
        String pass;
        for (Cookie x : cookies) {
            name = x.getName();
            pass = x.getValue();

            out.println("Name : " + name + "     Password : " + pass + "<br>");
        }

        out.println("</body></html>");
    }
}