<%--
  Created by IntelliJ IDEA.
  User: jagaa
  Date: 3/13/19
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Lab12</title>
</head>
<body>
<form action="login" method="post">
    Username: <input name="username" type="text"  value="${cookie.username.value}"/><br/>
    Password: <input name="password" type="password" /><br/>
    <%--<c:if test="${username != null}">checked</c:if>--%>
    <%
        Boolean checked = false;
        for (Cookie cookie: request.getCookies())
            if ("username".equals(cookie.getName())) {
                checked = true;
                break;
            }

        if (checked) out.println("<input type=\"checkbox\" name=\"rememberme\" value=\"true\" id=\"rememberme\" checked>");
        else out.println("<input type=\"checkbox\" name=\"rememberme\" value=\"true\" id=\"rememberme\" >");
    %>
    <label for="rememberme">Remember Me</label><br/>
    <input type="submit" value="login">
</form>
<p style="color:red">${err_msg}</p>
</body>
</html>
