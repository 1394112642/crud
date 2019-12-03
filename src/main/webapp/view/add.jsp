<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        #a {
            width: 100%;
            margin: 0 auto;
            border: 0px solid red;
            text-align: center;
        }
    </style>
</head>
<body>
<div id="a">
    <form action="http://localhost:8999/crud/add" METHOD="post">
        姓名：<input type="text" name="name" required><br>
        年龄：<input type="text" name="age" required><br>
        生日：<input type="date" name="bir" required><br>
        <input type="submit" value="添加">
    </form>
</div>
</body>
</html>