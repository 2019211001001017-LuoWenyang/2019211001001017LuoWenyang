<%@ page import="com.LuoWenyang.model.User" %>
 <%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2021/4/23
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%--
<%
    //read cookies
    Cookie[] allCookies=request.getCookies();
    for (Cookie c:allCookies){
        out.println("<br/>"+c.getName()+"---"+c.getValue());
    }
%>
--%>
<%
    User u=(User) session.getAttribute("user");
%>
<table>
    <tr><td>Username:</td><td><%=u.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=u.getPassword()%></td></tr>
    <tr><td>email:</td><td><%=u.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=u.getGender()%></td></tr>
    <tr><td>Birth Date:</td><td><%=u.getBirthDate()%></td></tr>
    <tr><td><a href="updateUser">UpdateInfo</a></td><tr>
</table>
<%@include file="footer.jsp"%>
