import java.io.*;
import java.util.*;
import jakarta.servlet.http.*;
import jakarta.servlet.*;

class Book {
    String title;
    String author;
    String ISBN;

    Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }
}

public class BookServer extends HttpServlet {
    ArrayList<Book> books;

    // public void init(ServletConfig sc) {
    // books = new ArrayList<Book>();

    // books.add(new Book("Java how to program", "Deitel", "9780136053064"));
    // books.add(new Book("Head First C#", "Andrew Stellman", "9781491976708"));
    // books.add(new Book("C#", "Svetlin Nakov", "9789544007737"));
    // }

    // protected void doGet(HttpServletRequest req, HttpServletResponse res) throws
    // ServletException, IOException {
    // PrintWriter pw = res.getWriter();

    // pw.println("<html><body><table><tr><th>Title</th><th>Author</th><th>ISBN</th></tr>");
    // }
}
