<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "
http://www.w3.org/TR/html4/loose.dtd
">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Kumar's Sweet Solutions</title>
</head>
<body>
<form action = "/addCustomer">
Name <input type = "text" name="name"><br>
Mobile Number <input type = "text" name="mobileNo"><br>
<input type = "Submit"><br>
</form>
<form action = "/showCustomer">
Mobile Number <input type = "text" name="mobileNo"><br>
<input type = "Submit"><br>
</form>
${UserInfo.name}
${UserInfo.mobileNo}
</body>
</html> 