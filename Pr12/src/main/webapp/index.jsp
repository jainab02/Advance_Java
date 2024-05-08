<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%!String ShowTime() {
		Date d = new Date();
		String msg = "";
		if (d.getHours() < 12) {
			msg += "Good Morning";
		} else if (d.getHours() > 12 && d.getHours() < 17) {
			msg += "Good Afternoon";
		} else if (d.getHours() > 17 && d.getHours() < 20) {
			msg += "Good Evening";
		} else if (d.getHours() > 20 && d.getHours() < 24) {
			msg += "Good Night";
		}
		return msg;
	}%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Messenger</title>
</head>
<body>
	<h1><%=ShowTime()%></h1>
</body>
</html>
