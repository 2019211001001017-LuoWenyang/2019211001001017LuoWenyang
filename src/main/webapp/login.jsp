<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2021/4/4
  Time: 11:12 上午
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>

<form method="post" id="form" action="${pageContext.request.contextPath}/LoginServlet">

    Username:<input type="text" id="username" name="username"  placeholder="Username"/><br/>
    Password:<input type="password"  id="password" name="password"  placeholder="Password"/><br/>
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
        //调用后端selvel进行数据传输！
        document.getElementById("form").submit();
    }
</script>
<%@include file="footer.jsp"%>

