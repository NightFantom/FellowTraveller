<%-- Created by Денис --%>
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
            <div class="menuBlock"><a href="${pageContext.request.contextPath}"><img src="images/logo.png"></a></div>
            <div class="menuBlock"><a href="${pageContext.request.contextPath}/driver.do"><img src="images/iDriver.png"></a></div>
            <div class="menuBlock"><a href="${pageContext.request.contextPath}/passenger.do"><img src="images/iPassenger.png"></a></div>
<%@include file="DriverAndPassengerPage/footer.jsp" %>