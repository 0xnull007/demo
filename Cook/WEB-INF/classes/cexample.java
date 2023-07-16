import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class cexample extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("username");
        String password = req.getParameter("password");

        Cookie c = new Cookie(name, password);
        c.setMaxAge(60 * 60);
        res.addCookie(c);

        out.println("</p>Dear " + name + ", Your cookie has been saved successfuly.</p>");
    }

}