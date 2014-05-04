<%-- Created by Денис --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
    <title>Я водитель</title>
</head>
<body>
<div id="basis">
    <div id="mainMenu">
        <div id="topRectangle"></div>
        <div id="center">
            <div class="menuBlock"><img src="images/logo.png"></div>
            <div class="form">
                <form action="${pageContext.request.contextPath}/" method="post">
                    <p>Откуда <input class="textInput" type="text" name="from"></p>

                    <p>Куда <input class="textInput" type="text" name="where"></p>

                    <p>Когда
                        <select class ="date" name = "day">
                            <option value = "1">1</option>
                            <option value = "2">2</option>
                            <option value = "3">3</option>
                        </select>
                        <select class ="date" name = "month">
                            <option value = "1">Янв</option>
                            <option value = "2">Фев</option>
                            <option value = "3">Март</option>
                        </select>
                    </p>

                    <p>E-mail <input class="textInput" type="text" name="mail"></p>

                    <p>Страница в ВК <input class="textInput" type="text" name="vkId"></p>

                    <p>Комментарий <textarea name="comment"></textarea></p>

                    <p class="agreement"><input type="checkbox" name="agree"> <a href="#">Принимаю условия
                        соглашения</a></p>
                    <input type="submit" class="textInput" value="Поехали">
                </form>
                <div id="data">
                </div>
                <div class="information"><a href="#">О проекте</a></div>
            </div>
        </div>
        <div id="bottomRectangle"></div>
    </div>
</div>
</body>
</html>