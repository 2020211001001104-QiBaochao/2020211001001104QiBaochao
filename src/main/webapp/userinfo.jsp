
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>userInfo</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<table>
    <tr><td>Username:</td><td><%=request.getAttribute("username")%></td></tr>
    <tr><td>Password:</td><td><%=request.getAttribute("password")%></td></tr>
    <tr><td>email:</td><td><%=request.getAttribute("email")%></td></tr>
    <tr><td>Gender:</td><td><%=request.getAttribute("gender")%></td></tr>
    <tr><td>Birth Date:</td><td><%=request.getAttribute("birthdate")%></td></tr>
</table>
</body>
<%@include file="footer.jsp"%>
</html>
