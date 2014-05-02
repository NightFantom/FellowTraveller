<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
    <title>Поиск попутчиков</title>
</head>
<body>
<div id = "basis">
    <div id = "mainMenu">
        <div id="topRectangle"></div>
        <div id="center">
            <div class="menuBlock"><img src="images/logo.png"></div>
            <form action="${pageContext.request.contextPath}/select.do" method="post">
                <div class="menuBlock"><a href="/jsp/driver.jsp"><img src="images/iDriver.png"></a></div>
                <div class="menuBlock"><a href="/jsp/passenger.jsp"><img src="images/iPassenger.png"></a></div>
            </form>
            <div id="information"><a href="#">О проекте</a></div>

        </div>
        <div id="bottomRectangle"></div>
    </div>
</div>
</body>
</html>