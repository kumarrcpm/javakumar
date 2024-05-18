<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "
http://www.w3.org/TR/html4/loose.dtd
">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Kumar's Sweet Solution</title>
</head>
<body>
Today's date: <%= (new 
java.util.Date
()).toLocaleString()%>
<form action = "/addCustomer">
username<input type = "text" name = "username"><br>
password<input type = "text" name = "password"><br>
<input type ="submit"><br>
</form>
${userInfo.username}
${userInfo.password}
</body>
</html> 