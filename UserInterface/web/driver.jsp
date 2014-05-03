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
                <form action="${pageContext.request.contextPath}/driverform.do" method="post">
                    <p>Откуда <input type="text" name="from"></p>
                    <p>Куда <input type="text" name="where"></p>
                    <p>Когда <input type="text" name="when"></p>
                    <p>E-mail <input type="text" name="mail"></p>
                    <p>Страница в ВК <input type="text" name="vkId"></p>
                    <p>Комментарий <input type="text" name="comment"></p>
                    <input type="submit" value="Поехали">
                </form>
            </div>
            <div id="information"><a href="#">О проекте</a></div>
        </div>
        <div id="bottomRectangle"></div>
    </div>
</div>
</body>
</html>