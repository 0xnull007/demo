import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String uname = request.getParameter("username");
        String pword = request.getParameter("password");

        HttpSession session = request.getSession();
        session.setAttribute("username", uname);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1/person";
            Connection con = DriverManager.getConnection(url, "root", "root");

            String query = "SELECT * FROM data WHERE Username = '" + uname + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                String name = rs.getString("Username");
                String pasword = rs.getString("Password");
                String userType = rs.getString("Type");

                if (uname.equalsIgnoreCase(name) && pword.equals(pasword)) {
                    session.setAttribute("name", name);
                    session.setAttribute("password", pasword);
                    session.setAttribute("type", userType);

                    if (userType.equals("User")) {
                        response.sendRedirect("userDash");
                    } else if (userType.equals("Admin")) {
                        response.sendRedirect("adminDash");
                    }
                } else if (!uname.equalsIgnoreCase(name) && pword.equals(pasword)) {
                    request.setAttribute("error", "noUserName");
                    request.getRequestDispatcher("errorPage").forward(request, response);
                } else if (uname.equalsIgnoreCase(name) && !pword.equals(pasword)) {
                    request.setAttribute("error", "noPwd");
                    request.getRequestDispatcher("errorPage").forward(request, response);
                } else {
                    request.setAttribute("error", "noCredentials");
                    request.getRequestDispatcher("errorPage").forward(request, response);
                }
            } else {
                request.setAttribute("error", "noUser");
                request.getRequestDispatcher("errorPage").forward(request, response);
            }

            st.close();
            con.close();

        } catch (Exception e) {
            out.println(e);
        }
    }
}
