<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
List of actions

<c:forEach items="${actionsList}" var="action">
    <br><a href="<c:out value="${action[1]}"/>"><c:out value="${action[0]}"/></a>
</c:forEach>

<br>

<form action="/SCPI/logout" method="post">
    <input type="submit" name="logout">
</form>
</body>
</html>