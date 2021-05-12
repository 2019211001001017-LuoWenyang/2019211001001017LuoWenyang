
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Update</h1>
<%
    User u=(User) session.getAttribute("user");
%>
<form method="post" action="register">
    <table>
        <tr> <td><input type="hidden" name="id" value="<%=u.getId()%>"></td></tr>
        <tr> <td>Username:</td> <td><input type="text" name="Username" value="<%=u.getUsername()%>" required><br/></td></tr>
        <tr> <td>password:</td> <td><input type="password" name="password"  value="<%=u.getPassword()%>" required minlength="8"><br/></td></tr>
        <tr> <td>Email:</td> <td><input type="email" name="Email" value="<%=u.getEmail()%>" required><br/></td></tr>
        <tr>
            <td>Gender:</td>
            <td>
                <input type="radio" name="Gender" value="Male" <%= "male".equals(u.getGender())?"checked":""%>> Male <!-- checked="checked"默认选择项 -->
                <input type="radio" name="Gender" value="Female" <%= "female".equals(u.getGender())?"checked":""%>> Female
            </td>
        </tr>
        <tr> <td>Date of Birth:</td> <td><input type="date" name="Date" value="<%=u.getBirthDate()%>" required dataformatas="yyyy-dd-mm"><br/></td></tr>
        <tr> <td></td><td><input type="submit" value="Save Changes"/></td>  </tr>
    </table>
</form>
<%@include file="footer.jsp"%>
