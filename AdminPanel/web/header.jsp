<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
    <meta http-equiv="content-type" content="text/html; utf-8">
    <title>Админ панель</title>
</head>
<body>
<div id="basis">
    <div id = "head">
        <table>
            <tr>
                <td><a href="${pageContext.request.contextPath}/getrecords.do?get=allRecords">Просмотр записей</a></td>
                <td><a href="${pageContext.request.contextPath}/getrecords.do?get=newRecords">Новые записи</a></td>
                <td><a href="${pageContext.request.contextPath}/settings.do">Настройки</a></td>
                <td><a href="${pageContext.request.contextPath}/logout.do">Выход</a></td>
            </tr>
        </table>
    </div>
    <div id="content">