import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the marks from the request parameters
        int subject1 = Integer.parseInt(request.getParameter("subject1"));
        int subject2 = Integer.parseInt(request.getParameter("subject2"));
        int subject3 = Integer.parseInt(request.getParameter("subject3"));

        // Calculate the total marks and percentage
        int totalMarks = subject1 + subject2 + subject3;
        double percentage = (totalMarks / 3.0);

        // Determine the class based on percentage
        String className;
        if (percentage >= 90) {
            className = "First Class";
        } else if (percentage >= 60) {
            className = "Second Class";
        } else if (percentage >= 40) {
            className = "Pass Class";
        } else {
            className = "Fail";
        }

        // Set the class and percentage as request attributes
        request.setAttribute("className", className);
        request.setAttribute("percentage", percentage);

        // Forward the request to the result.jsp page
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
