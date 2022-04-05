
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<br>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(request.getAttribute("message")==null){
        out.print("<h3>"+request.getAttribute("message")+"</h3>");
    }
%>
<form method="post" action="/2020211001001104QiBaochao_war_exploded/login">
    Username:<input type="text" name="username" ><br/>
    Password:<input type="password" name="password"><br/>
    <input type="submit" value="Login"/>
</form>
<%@ include file="footer.jsp"%>
</body>
</html>