<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2021/4/12
  Time: 9:13 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.LuoWenyang.model.User" %>
<h1>User List</h1>
<table border="1">
    <tr>
        <td>Id</td><td>Username</td><td>password</td><td>Email</td><td>Gender</td><td>Birthday</td>
    </tr>
    <%
//      ResultSet rs = (ResultSet) request.getAttribute("rsname");
//      if(rs == null){
        List<User> userList = (List<User>) request.getAttribute("userList");
        if(userList==null){
    %>
    <tr>
        <td>No Data!!!</td>
    </tr>
    <%  } else
        for (User user:userList) {
                out.println("<tr>");
                out.println("<td>"+user.getId()+"</td>");
                out.println("<td>"+user.getUsername()+"</td>");
                out.println("<td>"+user.getPassword()+"</td>");
                out.println("<td>"+user.getEmail()+"</td>");
                out.println("<td>"+user.getGender()+"</td>");
                out.println("<td>"+user.getBirthDate()+"</td>");
                out.println("<tr>");
        }
//            while (rs.next())
//        {
//                out.println("<tr>");
//                out.println("<td>"+rs.getString("id")+"</td>");
//                out.println("<td>"+rs.getString("username")+"</td>");
//                out.println("<td>"+rs.getString("password")+"</td>");
//                out.println("<td>"+rs.getString("email")+"</td>");
//                out.println("<td>"+rs.getString("gender")+"</td>");
//                out.println("<td>"+rs.getString("birthdate")+"</td>");
//                out.println("<tr>");
//        }
    %>
</table>
<%@include file="footer.jsp"%>