<%--
  Created by IntelliJ IDEA.
  User: ANH
  Date: 11/9/2023
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="update" modelAttribute="mail">
  <form:hidden path="id"/>
  <table>
    <tr>
      <th>Language</th>
      <td colspan="2">
        <form:select path="languages" items="${languages}"/>
      </td>
    </tr>
    <tr>
      <th>Page Size</th>
      <td>
        <span>Show <form:select path="pageSize" items="${page}"/> emails per page</span>
      </td>
    </tr>
    <tr>
      <th>Spams Filter</th>
      <td>
        <form:checkbox path="filter" value="Enable"/>Enable spams filter
      </td>
    </tr>
    <tr>
      <th>Signature</th>
      <td>
        <form:textarea path="signature"/>
      </td>
    </tr>
  </table>
  <input type="submit" value="Update">
  <input type="reset"value="Cancel">
</form:form>
</body>
</html>
