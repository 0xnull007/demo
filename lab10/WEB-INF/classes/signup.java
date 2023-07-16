import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class signup extends HttpServlet {
    Connection con;

    @Override
    public void init() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cms";
            con = DriverManager.getConnection(url, "root", "root");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int type = Integer.parseInt(request.getParameter("user_type"));
        if (type == 0) {
            Student(request, response);
        } else {
            Teacher(request, response);
        }

        PrintWriter pw = response.getWriter();
        pw.println("Successfully Signed Up.");
    }

    void Student(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        int semester = Integer.parseInt(request.getParameter("semester"));

        try {
            PreparedStatement pst1 = con
                    .prepareStatement("INSERT INTO authentication (email, password, user_type) values (?, ?, ?) ");
            pst1.setString(1, email);
            pst1.setString(2, password);
            pst1.setInt(2, 0);

            int rs = pst1.executeUpdate();

            PreparedStatement pst2 = con
                    .prepareStatement("INSERT INTO profile (email, name, semester, phone_no) values (?, ?, ?, ?) ");

            pst2.setString(1, email);
            pst2.setString(2, name);
            pst2.setInt(3, semester);
            pst2.setString(4, phone);

            rs = pst1.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void Teacher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        try {
            PreparedStatement pst1 = con
                    .prepareStatement("INSERT INTO authentication (email, password, user_type) values (?, ?, ?) ");
            pst1.setString(1, email);
            pst1.setString(2, password);
            pst1.setInt(2, 1);

            int rs = pst1.executeUpdate();

            PreparedStatement pst2 = con
                    .prepareStatement("INSERT INTO profile (email, name, phone_no) values (?, ?, ?) ");

            pst2.setString(1, email);
            pst2.setString(2, name);
            pst2.setString(4, phone);

            rs = pst1.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}