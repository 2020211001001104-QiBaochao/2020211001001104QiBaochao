<%--
  Created by IntelliJ IDEA.
  User: Minus one
  Date: 2022/3/5
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register_QiBaochao</title>
</head>
<body>
<h2>This Is My Homework_Code Exercise#1</h2>
<a href="http://localhost:8080/QiBaochao2020211001001104_war_exploded/qbc">Please Click Here^.^</a><br>
<h2>New User Registration!</h2><br/><br/>
<form method="post" action="/register">
   Userame:<input type="text" name="Username" placeholder ="Username" style="background:#FFFCEC;border: 0;width:300px;height:30px;margin-bottom: 10px;" required autofocus><br/>
    Password:<input type="password" name="password" minlength="8" placeholder ="Password" style="background:#FFFCEC;border: 0;width:300px;height:30px;margin-bottom: 10px;"><br/>
   Email:  <input type="email" name="Email" placeholder ="Email" style="background:#FFFCEC;border: 0;width:300px;height:30px;margin-bottom: 10px;"required autofocus><br/>
    Gender<input type="radio" name="sex" value="male" checked>Male
    <input type="radio" name="sex" value="female" style="margin-bottom: 10px;">Female
    <br/>
    Bithdate:<input type="date" name="BirthDate" placeholder ="Date of Birth(yyyy-mm-dd)" style="background:#FFFCEC;border: 0;height:30px;width:300px;margin-bottom: 10px;"><br/>
    <input type="submit" value="Register" style="background:#FF9224; color:#fff; width:100px; height:30px;border: 0;"/>
</form>
</body>
</html>
