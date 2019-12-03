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
    <style>
        #a {
            width: 100%;
            margin: 0 auto;
            border: 0px solid red;
            text-align: center;
        }
    </style>
    <title>Document</title>
</head>
<body>
<div id="a">
    <form action="http://localhost:8999/crud/update" METHOD="post">
        id： <input type="text" name="name" value="${param.id}" disabled="disabled"><br>
        姓名：<input type="text" name="name" value="${param.name}" required><br>
        年龄：<input type="text" name="age" value="${param.age}" required><br>
        生日：<input type="date" name="bir" value="${param.bir}" required><br>
        <input type="submit" value="修改">
    </form>
</div>
</body>
</html>