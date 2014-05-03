<%-- Created by Денис --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
    <title>Поиск попутчиков</title>
</head>
<body>
<div id="basis">
    <div id="mainMenu">
        <div id="topRectangle"></div>
        <div id="center">
            <div class="menuBlock"><img src="images/logo.png"></div>
            <div class="form">
                <%! String processor = ""; %>
                <form action="${pageContext.request.contextPath}/<%out.print(processor);%>" method="post">
                    <p>Откуда <input class="textInput" type="text" name="from"></p>
                    <p>Куда <input class="textInput" type="text" name="where"></p>
                    <p>Когда <input class="textInput" type="text" name="when"></p>
                    <p>E-mail <input class="textInput" type="text" name="mail"></p>
                    <p>Страница в ВК <input  class="textInput" type="text" name="vkId"></p>
                    <p>Комментарий <textarea name="comment"></textarea></p>
                    <p class="agreement"><input type="checkbox" name="agree"> <a href="#">Принимаю условия соглашения</a></p>
                    <input type="submit" class="textInput" value="Поехали">
                </form>
                <div id="data">