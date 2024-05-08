

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CountServlet
 */
@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Get the session associated with the request
        HttpSession session = request.getSession();

        // Retrieve the visit count from the session
        Integer visitCount = (Integer) session.getAttribute("visitCount");

        // If visitCount is null, it means it's the first visit
        if (visitCount == null) {
            visitCount = 1;
        } else {
            // Increment the visit count
            visitCount++;
        }

        // Update the visit count in the session
        session.setAttribute("visitCount", visitCount);

        // Set the content type of the response
        response.setContentType("text/html");

        // Get a PrintWriter object to write the HTML response
        PrintWriter out = response.getWriter();

        // Generate the HTML response
        out.println("<html>");
        out.println("<head><title>Visit Count page</title></head>");
        out.println("<body>");
        out.println("<h1>Visited this page : " + visitCount + " times</h1>");
        out.println("</body>");
        out.println("</html>");
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
