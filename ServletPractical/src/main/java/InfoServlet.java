import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Client Browser
		String browser = request.getHeader("User-Agent");

		// Client IP Address
		String ipAddress = request.getRemoteAddr();

		// Client Port No.
		int clientPort = request.getRemotePort();

		// Server Port No.
		int serverPort = request.getServerPort();

		// Local Port No.
		int localPort = request.getLocalPort();

		// Method used by client for form submission
		String method = request.getMethod();

		// System date and time
		Date date = new Date();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Information</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Client Information</h1>");
		out.println("<p>Client Browser: " + browser + "</p>");
		out.println("<p>Client IP Address: " + ipAddress + "</p>");
		out.println("<p>Client Port No.: " + clientPort + "</p>");
		out.println("<p>Server Port No.: " + serverPort + "</p>");
		out.println("<p>Local Port No.: " + localPort + "</p>");
		out.println("<p>Method used for form submission: " + method + "</p>");
		out.println("<p>System Date and Time: " + date.toString() + "</p>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
