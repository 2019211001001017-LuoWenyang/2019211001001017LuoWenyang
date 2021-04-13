<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2021/4/12
  Time: 10:33 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<table>
    <tr>
        <td>Id:</td><td><%=request.getAttribute("Id")%></td>
    </tr>
    <tr>
        <td>Username:</td><td><%=request.getAttribute("username")%></td>
    </tr>
    <tr>
        <td>password:</td><td><%=request.getAttribute("password")%></td>
    </tr>
    <tr>
        <td>Email:</td><td><%=request.getAttribute("email")%></td>
    </tr>
    <tr>
        <td>Gender:</td><td><%=request.getAttribute("gender")%></td>
    </tr>
    <tr>
        <td>Birthday:</td><td><%=request.getAttribute("birthdate")%></td>
    </tr>


</table>


<%@include file="footer.jsp"%>