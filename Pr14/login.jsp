<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.sql.*"%>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    try{
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	String url = "jdbc:mysql://localhost:8080/userdetails";
    	conn = DriverManager.getConnection(url, "root", "JAinab202");
    	
        pst = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
        pst.setString(1, username);
        pst.setString(2, password);
        rs = pst.executeQuery();
        if (rs.next()) {
            // Credentials are valid
 
            Cookie cookie = new Cookie("username", username);
            
            cookie.setMaxAge(60 * 60 * 24);
            
            // Add the cookie to the response
            response.addCookie(cookie);
            
            // Redirect to the JSP page that reads and displays the cookie information
            response.sendRedirect("display.jsp");
        } else {
            // Invalid credentials, show an error message or redirect back to the login page
            response.sendRedirect("error.jsp");
        }

    }
	catch(Exception e){ 
		e.printStackTrace();
	}

%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
</body>
</html>