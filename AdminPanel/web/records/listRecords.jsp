<%@ taglib uri="http://struts.apache.org/tags-logic" prefix ="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<table>
    <tr>
        <td>Откуда </td>
        <td>Куда</td>
        <td>День</td>
        <td>Месяц</td>
        <td>Страница ВКонтакте </td>
        <td>Комментарий</td>
    </tr>

    <logic:iterate id="user" name="Records" property="users">
        <tr>
            <td><bean:write name="user" property="from"/> </td>
            <td><bean:write name="user" property="where"/> </td>
            <td><bean:write name="user" property="day" format=""/> </td>
            <td><bean:write name="user" property="month" format=""/> </td>
            <td><bean:write name="user" property="vkId"/> </td>
            <td><bean:write name="user" property="comment"/> </td>
        </tr>
    </logic:iterate>
</table>