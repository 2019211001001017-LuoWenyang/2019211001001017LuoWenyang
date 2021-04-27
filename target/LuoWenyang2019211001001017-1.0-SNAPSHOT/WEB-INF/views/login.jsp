<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2021/4/4
  Time: 11:12 上午
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1> Login </h1>
<%
    if(!(request.getAttribute("message")==null)){
        //error
        out.println(request.getAttribute("message"));
    }
%>
<%
    // read cookies
   Cookie[] allCookies = request.getCookies();//give all cookies
    String username="",password="",rememberMeValue="";
    if(allCookies!=null){
        //we read 3 cookies
        for(Cookie cookie:allCookies){
            //get one by one
            if(cookie.getName().equals("cUsername")){
                username = cookie.getValue(); // get values of this cookies
            }
            if(cookie.getName().equals("cPassword")){
                password = cookie.getValue(); // get values of this cookies
            }
            if(cookie.getName().equals("cRememberMe")){
                rememberMeValue = cookie.getValue(); // get values of this cookies
            }
        }
    }

%>
<form method="post" id="form" action="login">

    Username:<input type="text" id="username" name="username"  placeholder="Username" value="<%=username %>"/><br/>
    Password:<input type="password"  id="password" name="password"  placeholder="Password" <%=password %>/><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeValue.equals("1")? "checked":"" %> />RememberMe<br/>
    <button type="button" onclick="loginVerify()" name="LoginButton">Login</button>

</form>
<script>
    function  loginVerify(){
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;
        if(username===''){
            alert('Username cant be null!!');
            return;
        }
        if(password===''){
            alert('Password cant be null!!!!');
            return;
        }
        //调用后端servlet进行数据传输！
        document.getElementById("form").submit();
    }
</script>
<%@include file="footer.jsp"%>

