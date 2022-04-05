<%--
  Created by IntelliJ IDEA.
  User: Minus one
  Date: 2022/3/5
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h2>Welcome to My Online Shop Home Page</h2> <br>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size=30/>
    <select name="search">
        <option value="Baidu">Baidu</option>
        <option value="Bing">Bing</option>
        <option value="Google">Google</option>
    </select>
    <input type="submit" value="Search"/>
</form>
<%@include file="footer.jsp"%>
</body>
