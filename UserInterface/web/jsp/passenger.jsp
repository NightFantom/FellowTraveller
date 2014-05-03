<%--
  Created by IntelliJ IDEA.
  User: Виктор
  Date: 01.05.2014
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Passenger panel</title>


    <script language="JavaScript" type="text/javascript">

        function getXmlHttp(){
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
            if (!xmlhttp && typeof XMLHttpRequest!='undefined') {
                xmlhttp = new XMLHttpRequest();
            }
            return xmlhttp;
        }

        function updatePage(){

        }
        function getDrivers()
        {
            var req = getXmlHttp();
            var statusElem = document.getElementById('idDriver');
            req.onreadystatechange = function ()
            {
                // onreadystatechange активируется при получении ответа сервера
                if (req.readyState == 4)
                {
                    // если запрос закончил выполняться

                    statusElem.innerHTML = req.statusText // показать статус (Not Found, ОК..)

                    if (req.status == 200)
                    {
                        // если статус 200 (ОК) - выдать ответ пользователю
                        statusElem.innerHTML =  req.responseText;
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
<div align = "center">


        <p>From <input type="text" name="from"></p>
        <p>Where <input type="text" name="where"></p>
        <p>When <input type="text" name="when"></p>
        <p>e-mail <input type="text" name="mail"></p>
        <p>Id <input type="text" name="vkId"></p>
        <p>Comment <input type="text" name="comment"></p>
        <input type="button"onclick="getDrivers()" value="Enter">


</div>
<div id="idDriver"></div>
</body>
</html>
