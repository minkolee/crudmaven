<%--
  Created by IntelliJ IDEA.
  User: Minko
  Date: 2019/3/15
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Add Customer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2 style="text-align: center;">Add a new Customer</h2>
    </div>
</div>


<div id="container">
    <div id="content">
        <form:form action="saveCustomer" modelAttribute="customer" method="post">

            <form:hidden path="id"/>

            First Name: <form:input path="firstName" required="required"/>
            <form:errors path="firstName" cssClass="error"/>
            <br><br>
            Last Name: <form:input path="lastName" required="required"/>
            <form:errors path="lastName" cssClass="error"/>
            <br><br>
            Email: <form:input path="email" type="email" required="required"/>
            <form:errors path="email" cssClass="error"/>
            <br><br>
            <input type="submit" value="Save">
        </form:form>
        <br><br>
        <p><a href="${pageContext.request.contextPath}/customer/list">Back to List</a></p>
    </div>
</div>
</body>
</html>