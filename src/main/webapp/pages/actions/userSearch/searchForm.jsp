<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%><!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
List of actions
<% String s = null;%>
<br>
<form action="/actions/userSearch" method="post">
    Id:
    <br><input type="text" name="id">
    ???:
    <br><input type="text" name="firstName">
    ???????:
    <br><input type="text" name="lastName">
    <input type="submit" value="?????">
</form>
</body>
</html>