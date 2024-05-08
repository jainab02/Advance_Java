import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String enrollmentNo = request.getParameter("enrollmentNo");
        String sname = request.getParameter("sname");
        String semester = request.getParameter("semester");
        String mobileNo = request.getParameter("mobileNo");

        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "JAinab@02";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection conn = DriverManager.getConnection(url, username, password);

            // SQL query to insert a new record into the "students" table
            String sql = "INSERT INTO students VALUES (?, ?, ?, ?)";

            // Create a prepared statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, enrollmentNo);
            statement.setString(2, sname);
            statement.setString(3, semester);
            statement.setString(4, mobileNo);

            // Execute the query
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                // Record inserted successfully
                response.getWriter().println("Student details saved successfully.");
            } else {
                response.getWriter().println("Failed to save student details.");
            }

            // Close the database connection
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred while processing the request.");
        }
    }
}
