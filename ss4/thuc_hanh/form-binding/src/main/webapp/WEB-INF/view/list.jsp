<%--
  Created by IntelliJ IDEA.
  User: ANH
  Date: 11/9/2023
  Time: 11:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table" border="1"s>
  <thead class="thead-dark">
  <tr>
    <th >Language</th>
    <th >Page Size</th>
    <th >spams filter</th>
    <th >signature</th>
    <th >Action</th>
  </tr>
  </thead>
  <c:forEach items="${list}" var="l">
    <tbody>
    <tr>
      <td>${l.languages}</td>
      <td>${l.pageSize}</td>
      <td>${l.filter}</td>
      <td>${l.signature}</td>
      <td>
        <a href="/home/detail?id=${l.id}">Edit</a>
      </td>
    </tr>
    </tbody>
  </c:forEach>
</table>
</body>
</html>
