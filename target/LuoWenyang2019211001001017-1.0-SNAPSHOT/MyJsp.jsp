<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2021/3/16
  Time: 11:42 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<a href="index.jsp">go to ecjtu!</a><!-- method is GET-->
<form method="post"><!-- what is method when we use  form?-->  <!-- It's GET,why?  default is GET form data is added in the URLm u can form-->
    <!-- It's better to use POST in form , data is not added in the URL-->
    Name:<input type="text" name = "name"><br/>
    ID:<input type="text" name = "id"><br/>
    <input type="submit" value="Send data to Server"/>


</form>
</body>
</html>