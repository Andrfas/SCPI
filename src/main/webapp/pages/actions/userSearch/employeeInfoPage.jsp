<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
${employee.getFirstName()}:${employee.getLastName()}
<br>
<br>
Список действий с артефактами:
<table border="1">
    <tr>
        <td>Действие</td>
        <td>Артефакт</td>
        <td>Досье</td>
        <td>Дата</td>
    </tr>

<c:forEach items="${actionList}" var="action">
    <%--<br><a href="<c:out value="${action.get()}"/>"><c:out value="${action.getName()}"/></a>--%>
    <tr>
        <td><c:out value="${action.getArtifActionType().getName()}"/></td>
        <td><c:out value="${action.getArtifact().getId()}"/></td>
        <td><c:out value="${action.getDossier().getId()}"/></td>
        <td><c:out value="${action.getDate()}"/></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
