package ServletPr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MinSer
 */
@WebServlet("/MinSer")
public class MinSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number1 = Integer.parseInt(request.getParameter("num1"));
        int number2 = Integer.parseInt(request.getParameter("num2"));
        int minimum = Math.min(number1, number2);
        PrintWriter out = response.getWriter();
        out.println("<h1> The Minimum of 2 is </h1> "+minimum);
	}

}


