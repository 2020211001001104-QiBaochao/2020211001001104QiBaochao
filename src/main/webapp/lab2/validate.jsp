<%--
  Created by IntelliJ IDEA.
  User: Minus one
  Date: 2022/5/25
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<%--Todo 1: Use <jsp:useBean> to create a Login bean instance in request scope --%>
<jsp:useBean id="user" class="com.QiBaochao.lab2.Login" scope="request"></jsp:useBean>
<%--Todo 2: Use <jsp:setProperty> to set  beans' property username and password--%>
<jsp:setProperty name="user" property="username" value="${param.username}"/>
<jsp:setProperty name="user" property="password" value="${param.password}"/>
<%
    //todo 3: use if check username is admin and ppassword is admin
    if (user.getUsername().equals("admin")&&user.getPassword().equals("admin")){
        request.setAttribute("user",user);
%>
<%--todo 4: use jsp:forward to welcome.jsp page--%>
<jsp:forward page="welcome.jsp"></jsp:forward>
<%--todo 5: else part{ --%>
<%
}else {
%>

<%
    // todo 6: print username or password error message
    if (!user.getUsername().equals("admin")||!user.getPassword().equals("admin")){
        out.println("Username Password Error");
    }
%>
<%--todo 7: use jsp:include login.jsp page --%>
<jsp:include page="login.jsp"></jsp:include>
<%--todo 8: close else --%>
<%
    }
%>
</body>
</html>