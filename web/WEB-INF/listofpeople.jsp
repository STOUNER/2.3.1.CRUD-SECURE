<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: DENIS
  Date: 07.01.2021
  Time: 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>AGE</th>
            <th>DELETE</th>
            <th>EDIT</th>
        </tr>
        <c:forEach items="${listUser}" var="people">
            <tr>
                <td>${people.id}</td>
                <td>${people.name}</td>
                <td>${people.age}</td>
                <td>
                    <a href="/CRUD_app_sh_war_exploded/delete-user?id=${people.id}">Delete</a>
                </td>
                <td>
                    <a href="/CRUD_app_sh_war_exploded/user-edit?id=${people.id}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/CRUD_app_sh_war_exploded/user-create">Add User</a>
</div>
</body>
</html>
