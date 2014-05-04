<%--
  Created by IntelliJ IDEA.
  User: Виктор
  Date: 01.05.2014
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
    <title>Я пассажир</title>


    <script language="JavaScript" type="text/javascript">

        function getXmlHttp() {
            var xmlhttp;
            try {
                xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (E) {
                    xmlhttp = false;
                }
            }
            if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
                xmlhttp = new XMLHttpRequest();
            }
            return xmlhttp;
        }

        function updatePage() {

        }
        function getDrivers() {
            var req = getXmlHttp();
            var statusElem = document.getElementById('data');
            req.onreadystatechange = function () {
                // onreadystatechange активируется при получении ответа сервера
                if (req.readyState == 4) {
                    // если запрос закончил выполняться

                    statusElem.innerHTML = req.statusText // показать статус (Not Found, ОК..)

                    if (req.status == 200) {
                        // если статус 200 (ОК) - выдать ответ пользователю
                        statusElem.innerHTML = req.responseText;
                    }
                    // тут можно добавить else с обработкой ошибок запроса
                }

            }

            req.open('get', '/userinterface//passengerform.do', true);
            // req.onreadystatechange = updatePage;
            req.send(null);
            statusElem.innerHTML = 'Ожидаю ответа сервера...'
        }

    </script>
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