<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 07.05.2014
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <%@include file="DriverAndPassengerPage/header.jsp"%>
    <title>Я пассажир</title>

</head>
<body>
<div id="basis">
    <div id="mainMenu">
        <div id="topRectangle"></div>
        <div id="center">
            <div class="menuBlock"><a href="${pageContext.request.contextPath}"><img src="images/logo.png"></a></div>
            <div class="form">
                <form>
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
                    <input type="button" class="textInput" value="Поехали" onclick="postAjax('${pageContext.request.contextPath}/getRecords.do',document.forms[0],'showServerAnswer')">
                    <div id="showServerAnswer"></div>
                </form>
                <div class="information"><a href="#">О проекте</a></div>
            </div>
        </div>
        <div id="bottomRectangle"></div>
    </div>
</div>
</body>
</html>