<%@ page import="com.QiBaochao.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 86136
  Date: 2022/4/00017
  Time: 上午 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<h1>User Info</h1>
<%
    User u = (User)session.getAttribute("user");
%>

<table>
    <tr>
        <td>Username:</td><td><%=u.getUsername()%></td>
    </tr>
    <tr>
        <td>Password:</td><td><%=u.getPassword()%></td>
    </tr>
    <tr>
        <td>Email:</td><td><%=u.getEmail()%></td>
    </tr>
    <tr>
        <td>Gender:</td><td><%=u.getGender()%></td>
    </tr>
    <tr>
        <td>Birth Date:</td><td><%=u.getBirthDate()%></td>
    </tr>
</table>
<a href="updateUser">Update</a> <br>

<%@ include file="footer.jsp"%>
