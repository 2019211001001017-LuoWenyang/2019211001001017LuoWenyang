<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2021/3/17
  Time: 2:57 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
NEW User Registration!!!
<form method="post" id="form">
   username <input type="text" id="username" name="username"  placeholder="Username"/><br/>
   password <input type="password" id="password" name="password" placeholder="password"/><br/>
    Email  <input type="text" id="email" name="email" placeholder="Email"/><br/>
    <td>Gender：</td>
    <td>
        <input type="radio" name="sex"  id="man1" value="1" />
        <label for="man1">Male</label>
        <input type="radio" name="sex" id="man2" value="0" />
        <label for="man2">Female</label>
    </td><br/>
  Birth  <input type="text" id="birth" name="birth" placeholder="Data of Birth(yyyy=mm-dd)"/><br/>
    <input type="submit" id="Register" name="Register" placeholder="Register" onclick="loginVerify()"/><br/>
</form>

</body>
</html>
<script>
    function  loginVerify(){
        const username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        if(username==''){
            alert('Username cant be null!!');
            return;
        }
        if(password==''){
            alert('Password cant be null!!!!');
            return;
        }
    }
</script>
