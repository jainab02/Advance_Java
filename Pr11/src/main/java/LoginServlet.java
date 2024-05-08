import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(isValidPassword(password)) {
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(24*60*60);
			response.addCookie(cookie);
			response.sendRedirect("DisplayCookie");
		}
		else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Login Error</title></head><body>");
			out.println("<h1>Login Error</h1>");
			out.println("<h3>Invalid Password.....<br>Please Try Again.....</h3>");
			out.println("</body></html>");
		}
		
	}
	
	private boolean isValidPassword(String password) {
	    // Password must have at least 1 capital letter, 1 number, and 1 symbol
	    String pattern = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$";
	    return password.matches(pattern);
	}
	protected void service(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException {
        doPost(request, response);
}


}
