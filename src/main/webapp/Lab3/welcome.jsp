<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Author:<span style="color: red">2020211001001104-QiBaochao</span></h1>
<h2>Welcome,<%-- todo 8 use c:out to print username from parammeter --%>
    <%=request.getParameter("username")%>
</h2>
</body>
</html>