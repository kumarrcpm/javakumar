<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "
http://www.w3.org/TR/html4/loose.dtd
">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Kumar current Date</title>
</head>
<body>
Today's date: <%= (new 
java.util.Date
()).toLocaleString()%>
<form action ="/addCustomer">
Username <input type = "text" name ="username"><br>
Door No<input type = "text" name ="doorNo"><br>
<input type="submit"><br>
</form>
<form action ="/showCustomer">
Username <input type = "text" name ="username"><br>
Door No<input type = "text" name ="doorNo"><br>
<input type="submit"><br>
</form>
${userInfo.username}
${userInfo.doorNo}
</body>
</html> 