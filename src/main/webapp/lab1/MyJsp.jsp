<%--
  Created by IntelliJ IDEA.
  User: Minus one
  Date: 2022/5/18
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyJsp.jsp</title>
</head>
<body>
<span>I am MyJsp.jsp</span>
<h2>The action is "MyDearServletURL"</h2>
<form method="post"  action="../MyDearServletURL">
    name:<input type="text" name="name"><br/>
    class:<input type="text" name="class"><br/>
    ID:<input type="text" name="ID"><br/>
    <input type="submit" name="submit" value="Send data to server">
</form>
<hr/>
<h2>The action is "MyDearJsp.jsp"</h2>
<form method="post" action="./MyDearJsp.jsp">
    name:<input type="text" name="name"><br/>
    class:<input type="text" name="_class"><br/>
    ID:<input type="text" name="ID"><br/>
    <input type="submit" name="submit" value="Send data to server">
</form>
</body>
</html>
