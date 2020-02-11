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
    <title>成功创建用户</title>
</head>
<body>
<p>${user.userName}创建成功.</p>
<p>详细信息是:</p>
<ol>
    <li>${user}</li>
</ol>

</body>
</html>
