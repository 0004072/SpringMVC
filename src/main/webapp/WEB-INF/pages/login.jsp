<%@ include file="include.jsp"%>
<html>

<head><title>Login</title></head>

<body>
    <h3>Login page</h3>
    <form:form action="processlogin.htm" method="POST" modelAttribute="user">
        <table>
            <c:if test="${success == false}">
                <tr>
                    <td colspan="2">
                        <p style="color:#ff0000">${error}</p>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Login"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>