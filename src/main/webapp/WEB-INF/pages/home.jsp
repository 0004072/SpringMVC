<%@ include file="include.jsp"%>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>Home Page</h2>
    <p>Hello
    <c:if test="${success == true}"><% %>
        <script language="javascript">
            var uname = '${sessionScope.user.info.username}';
            alert("Hello " + uname);
        </script>
    </c:if>
    <c:choose>
        <c:when test="${sessionScope.user.valid == true}">
            ${sessionScope.user.info.username}! (<a href="logout.htm">LOGOUT</a>)</p>
        <p>Last visited on : <%=new Date().toString()%></p>
        </c:when>
        <c:otherwise>
            Guest! (<a href="login.htm">LOGIN</a>)</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
