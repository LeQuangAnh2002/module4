<%--
  Created by IntelliJ IDEA.
  User: ANH
  Date: 11/3/2023
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${resultSet != null}">
  <h2>Word: ${search}</h2>
  <h2>Result: ${resultSet}</h2>
</c:if>
<c:if test="${resultSet == null}">
  <h2>Not Found</h2>
</c:if>
</body>
</html>
