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
    <style type="text/css">
        body {
            margin: 0;
            font-size: 62.5%;
            font-family: Verdana, Arial, Helvetica, sans-serif;
            padding: 15px 0;
            background: #eeeeee;
        }

        td {
            height: 30px;
            text-align: center;
        }
    </style>
    <script src="${path}/js/jquery-3.3.1.min.js"></script>
    <script>
        $.ajax({
            url: "${path}/findAll",
            type: "post",
            dataType: "json",
            success: function (date) {

            }
        })
    </script>

    <title>Document</title>
</head>
<body>
<center>
    <a href="${path}/view/add.jsp">添加学生</a>
</center>
<table bordercolor='#898E90' align='center' border='3px' cellpadding='5px' cellspacing="0px">
    <tbody>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>生日</td>
        <td>操作</td>
    </tr>

    <c:forEach var="a" items="${sessionScope.students}">
        <tr>
            <td>${a.id}</td>
            <td>${a.name}</td>
            <td>${a.age}</td>
            <td>${a.bir}</td>
            <td>
                <a href="${path}/view/update.jsp?id=${a.id}&name=${a.name}&age=${a.age}&bir=${a.bir}">修改</a>
                <a href="${path}/remove?id=${a.id}">删除</a>
            </td>

        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>