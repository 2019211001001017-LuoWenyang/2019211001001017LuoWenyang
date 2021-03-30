<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2021/3/22
  Time: 9:16 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/register">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender:<input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="female">Female<br/>
    Date of Birth :<input type="text" name="birthDate"/><br/>
    <input type="submit" value="Register"/>
</form>

</body>
</html>
