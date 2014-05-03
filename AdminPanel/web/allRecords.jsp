<%@include file="header.jsp"%>
<p><a href="${pageContext.request.contextPath}/getrecords.do?get=allRecords">Просмотр всех записей</a></p>
<table>
    <tr>
        <td>Откуда </td>
        <td>Куда</td>
        <td>Когда </td>
        <td>Страница ВКонтакте </td>
        <td>Комментарий</td>
    </tr>
    <logic:iterate id="user" name="Records" property="users">
        <tr>
            <td><bean:write name="user" property="from"/> </td>
            <td><bean:write name="user" property="where"/> </td>
            <td><bean:write name="user" property="when"/> </td>
            <td><bean:write name="user" property="vkId"/> </td>
            <td><bean:write name="user" property="comment"/> </td>
        </tr>
    </logic:iterate>
</table>

<%@include file="footer.jsp"%>