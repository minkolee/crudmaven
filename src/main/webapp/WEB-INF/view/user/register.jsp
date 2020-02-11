<%--
  Created by IntelliJ IDEA.
  User: Minko
  Date: 2020-02-11
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
</head>
<body>
<form method="post" action="<c:url value="/user"/>">
    <table>
        <tr>
            <td>用户名: </td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>密码: </td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>姓名: </td>
            <td><input type="text" name="realName"></td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">提交</button></td>
        </tr>
    </table>
</form>
</body>
</html>
