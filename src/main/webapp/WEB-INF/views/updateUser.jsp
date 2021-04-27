<%@page import="com.LuoWenyang.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2021/4/27
  Time: 10:51 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<!-- need form-->

<%
    //get user from session
    User u = (User)session.getAttribute("user");
%>

<form method="post" action="updateUser">
    <input type="hidden" name="id" value="<%=u.getId()%>">
    username<input type="text" name="username" value="<%= u.getUsername()%>"/><br/>
    password<input type="password" name="password" value="<%= u.getPassword()%>"/><br/>
    Email<input type="text" name="email" value="<%= u.getEmail()%>"/><br/>
    Gender:<input type="radio" name="gender" value="male" <%= "male".equals(u.getGender())?"checked":""%>>Male
    <input type="radio" name="gender" value="female" <%= "female".equals(u.getGender())?"checked":""%>>Female<br/>
    Date of Birth :<input type="date" name="birthDate" value="<%= u.getBirthDate()%>"/><br/>
    <input type="submit" value="Save Change"/>
</form>

<%@include file="footer.jsp"%>