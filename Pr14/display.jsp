<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="java.io.IOException" %>
<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                out.println("Welcome, " + cookie.getValue() + "!");
                break;
            }
        }
    } else {
        // No cookies found
        out.println("No cookie found.");
    }
%>
<a href="delete.jsp">Delete Cookie</a>
