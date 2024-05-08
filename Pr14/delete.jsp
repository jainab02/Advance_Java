<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="java.io.IOException" %>
<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                // Delete the cookie by setting its max age to 0
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
    }
    // Redirect back to the login page or any other desired page
    response.sendRedirect("deleteok.jsp");
%>
