<%@include file="header.jsp"%>
<h1><%= "Welcome to my home page" %>
</h1>
<form method="get" target="_blank" action="SearchServlet">
    <input type="text" name="txt" size="30"/>
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search"/>
</form>



<br/>
<a href="hello-servlet">Hello Servlet--Week1</a><br/>
<a href="StuInfo">Student Info Servlet-Week2</a><br/>
<a href="life">Life Cycle Servlet-Week3</a><br/>
<a href="register.jsp">Register-getParameter-Week3</a><br/>
<a href="config">Config parameter-Week4</a><br/>
<a href="register.jsp">Register JDBC-Week4</a><br/>
<a href="hello-servlet">include-Week5</a><br/>
<a href="login.jsp">Login-Week5</a><br/>
<%@include file="footer.jsp"%>