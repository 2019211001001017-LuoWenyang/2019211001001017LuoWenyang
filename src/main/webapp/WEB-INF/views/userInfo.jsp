<%@ page import="com.LuoWenyang.model.User" %><%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2021/4/12
  Time: 10:33 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
  User user = (User)request.getAttribute("user");
%>
<table>
    <tr>
        <td>Id:</td><td><%=user.getId()%></td>
    </tr>
    <tr>
        <td>Username:</td><td><%=user.getUsername()%></td>
    </tr>
    <tr>
        <td>password:</td><td><%=user.getPassword()%></td>
    </tr>
    <tr>
        <td>Email:</td><td><%=user.getEmail()%></td>
    </tr>
    <tr>
        <td>Gender:</td><td><%=user.getGender()%></td>
    </tr>
    <tr>
        <td>Birthday:</td><td><%=user.getBirthDate()%></td>
    </tr>


</table>


<%@include file="footer.jsp"%>