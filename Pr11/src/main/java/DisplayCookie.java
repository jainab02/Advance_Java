import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.*;
import java.io.*;

public class DisplayCookie extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                    break;
                }
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Display Cookie</title></head><body>");
        out.println("<h1>Display Cookie</h1>");

        if (username != null) {
            out.println("<p>Welcome, " + username + "!</p>");
        } else {
            out.println("<p>Cookie not found.</p>");
        }
            out.println("</body></html>");
    }
}
