<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 14.07.14
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
    <title>О проекте</title>
</head>
<body>
<div id = "basis">
    <div id = "mainMenu">
        <div id="topRectangle"></div>
        <div id="center">
            <div class="menuBlock"><a href="${pageContext.request.contextPath}"><img src="images/logo.png"></a></div>
            <div class="documentation">
                <p>Здравствуйте! Мы команда молодых разработчиков, которая стремиться сделать наш мир лучше.</p>
                <p>Цель нашего проекта "Попутчик" - сделать людей более общительными, отзывчивыми и бескорыстными.</p>
                <p>Как это работает? У многих есть автомобили, но у многих их и нет. Водители, готовые подвести незнакомого человека БЕСПЛАТНО(!!!), заносят свой маршрут
                    на сайт. Потенциальные пассажиры находят их. Пассажир и водитель просматривают профиль друг друга в соц сетях. Если они устраивают друг друга, то
                    списываются и едут.</p>
                <p> В замен пассажир может отблагодарить водителя хорошей беседой или чем-нибудь вкусненьким:)</p>
            </div>
            <div class="information"><a href="${pageContext.request.contextPath}/aboutProject.do">О проекте</a></div>
        </div>
        <div id="bottomRectangle"></div>
    </div>
</div>
</body>
</html>
