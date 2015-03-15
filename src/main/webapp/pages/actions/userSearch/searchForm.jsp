<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %><!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
Введите информацию для поиска:
<br>
<form action="/SCPI/actions/userSearch" method="post">
    Id:
    <br><input type="text" name="id">
    <br><br>
    Имя:
    <br><input type="text" name="firstName">
    <br><br>
    Фамилия:
    <br><input type="text" name="lastName">
    <br><br>
    <input type="submit" value="Искать">
</form>
</body>
</html>