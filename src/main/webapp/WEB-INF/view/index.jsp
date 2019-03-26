<%--
  Created by IntelliJ IDEA.
  User: Minko
  Date: 2019-03-15
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页面</title>
    <style>
        a {
            text-decoration: none;
            color: brown;
        }
    </style>
</head>
<body>
<h1 style="text-align: center;">欢迎来到第一个增删改查项目</h1>
<p>点击<a href="${pageContext.request.contextPath}/customer/list">这里</a>进入列表页</p>
<p>点击<a href="${pageContext.request.contextPath}/test/hello">这里</a>访问REST测试</p>
<p>点击<a href="${pageContext.request.contextPath}/api/customers">这里</a>客户列表</p>
<p>点击<a href="${pageContext.request.contextPath}/api/customers/1">这里</a>单个客户</p>
</body>
</html>
