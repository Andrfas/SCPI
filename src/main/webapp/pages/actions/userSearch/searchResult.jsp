<%@ page import="entities.employees.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<c:forEach items="${employeeList}" var="employee">
    <br><a href="/SCPI/employee?id=<c:out value="${employee.id}"/>"><c:out value="${employee.firstName}"/> <c:out
        value="${employee.lastName}"/></a>
</c:forEach>
</body>
</html>
