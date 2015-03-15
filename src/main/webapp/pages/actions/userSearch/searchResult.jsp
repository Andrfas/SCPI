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
<%=((List<Employee>) request.getAttribute("employeeList")).get(0).getFirstName()%>
<c:forEach items="${employeeList}" var="employee">
    <%--<br><a href="<c:out value="${employee}"/>"><c:out value=" "/></a>--%>
    ${employee.firstName}:${employee.lastName}<br>
</c:forEach>
</body>
</html>
