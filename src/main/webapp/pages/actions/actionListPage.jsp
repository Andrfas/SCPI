<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ page import="java.util.List" %>--%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%><!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
List of actions
<%--<% List<String[]> actionList = (List<String[]>) request.getAttribute("actionsList"); --%>
    <%--for (int i=0; i<actionList.size(); i++) {--%>
        <%----%>
    <%--}--%>
<%--%>--%>

<%--<c:forEach items="${actionsList}" var="action">--%>
    <%--<br><a href="<c:out value="${action[1]}"/>"><c:out value="${action[0]}"/></a>--%>
<%--</c:forEach>--%>

<br>
<form action="/SCPI/logout" method="post">
    <input type="submit" name="logout">
</form>
</body>
</html>