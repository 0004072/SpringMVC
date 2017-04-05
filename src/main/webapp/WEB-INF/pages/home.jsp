<%@ include file="include.jsp"%>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>Home Page</h2>
    <p>Hello
    <c:choose>
        <c:when test="${validUser == true}">
            ${user.username}! (LOGOUT)</p>
            <p>Last visited on : <%=new Date().toString()%></p>
        </c:when>
        <c:otherwise>
            Guest! (<a href="login.htm">LOGIN</a>)</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
