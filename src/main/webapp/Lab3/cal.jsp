<%--
  Created by IntelliJ IDEA.
  User: Minus one
  Date: 2022/6/1
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator Application</title>
</head>
<body>
<%
    Cookie[] cookies=request.getCookies();
    String FirstVal="";
    String SecondVal="";
    String Result="";
    String Name = "";
    String length = "";
    if (cookies!=null){
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("cFirstVal")){
                FirstVal=cookie.getValue();
            }
            if (cookie.getName().equals("cSecondVal")){
                SecondVal=cookie.getValue();
            }
            if (cookie.getName().equals("cResult")){
                Result=cookie.getValue();
            }
            if (cookie.getName().equals("cName")){
                Name=cookie.getValue();
            }
            if (cookie.getName().equals("cLength")){
                length=cookie.getValue();
            }
        }
    }
    //update 5 user basepath
%>

<form method="post" id="form" action="CalServlet">
    <table>
        <tr>
            <td >
                FirstVal: <input type="text" id="FirstVal" name="FirstVal" width="50px" value="<%=FirstVal%>"/>
            </td>
            <td >
                Enter a Name:<input type="text" id="Name" name="Name" width="50px" value="<%=Name%>" />
            </td>
        </tr>
        <tr>
            <td>
                SecondVal: <input type="text" id="SecondVal" name="SecondVal" width="50px" value="<%=SecondVal%>"/>
            </td>
            <td>
                Length:<input type="text" id="Length" name="Length" width="50px" value="<%=length%>"/>
            </td>
        </tr>
        <tr>
            <td>
                Result: <input type="text" id="Result" name="Result" width="50px" value="<%=Result%>"/>
            </td>
            <td>
            </td>
        </tr>
    </table>

    <input type="button" onclick="NumberValidation('Add')" value="Add"/>
    <input type="button" onclick="NumberValidation('Subtract')"  value="Subtract"/>
    <input type="button" onclick="NumberValidation('Multiply')"  value="Multiply"/>
    <input type="button" onclick="NumberValidation('Divide')" value="Divide"/>
    <input type="button" onclick="NameValidation('Compute Length')"    value="Compute Length"/>
    <button type="button" onclick="ResetAll()" name="Reset">Reset</button>
    <input type="hidden" name="action">
</form>
</body>
<script>
    function submitForm(action){
        let form=document.getElementById("form");
        if(action==="Add")
            document.forms["form"]["action"].value="Add";
        else if(action==="Subtract")
            document.forms["form"]["action"].value="Subtract";
        else if(action==="Multiply")
            document.forms["form"]["action"].value="Multiply";
        else if(action==="Divide")
            document.forms["form"]["action"].value="Divide";
        else if(action==="Compute Length")
            document.forms["form"]["action"].value="Compute Length";
        form.submit();
    }
    function  NumberValidation(action){
        let FirstVal = document.getElementById("FirstVal").value;
        let SecondVal = document.getElementById("SecondVal").value;
        if(FirstVal === ''){
            alert('First Value  is NULL!!');
            return;
        }
        if(SecondVal === ''){
            alert('Second Value is NULL !!');
            return;
        }
        FirstVal = Number(FirstVal)
        SecondVal = Number(SecondVal)
        if(!Number.isFinite(FirstVal)){
            alert('First Value is not a Number!!');
            return false;
        }
        if(!Number.isFinite(SecondVal)){
            alert('Second Value is not a Number!!');
            return false;
        }
        if(action==="Divide" && SecondVal === 0)
        {
            alert('The denominator cant be 0!!');
            return false;
        }
        submitForm(action);
    }
    function ResetAll(){
        document.getElementById("form").reset();
    }
    function NameValidation(action){
        let Name = document.getElementById("Name").value;
        Name = Number(Name)
        if(Number.isFinite(Name)){
            alert("Name id not valid")
            return false;
        }
        submitForm(action);
    }
</script>
</html>