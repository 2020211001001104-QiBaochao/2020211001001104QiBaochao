<%--
  Created by IntelliJ IDEA.
  User: 86136
  Date: 2022/4/00017
  Time: 上午 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if (!(request.getAttribute("message")==null)){
        //error
        out.println("<h3>"+request.getAttribute("message")+"</h3>");
    }
%>
<form method="post" action="login">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    <input type="submit" value="Login"/>
</form>

<%@include file="footer.jsp"%>
