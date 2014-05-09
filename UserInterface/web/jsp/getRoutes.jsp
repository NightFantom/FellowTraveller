<%@ taglib uri="http://struts.apache.org/tags-logic" prefix ="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="tableRecords" c>
    <tr class="tableHeader">
        <td class="place">Откуда </td>
        <td class="place">Куда</td>
        <td class="date">День</td>
        <td class="date">Месяц</td>
        <td class="date">Страница ВКонтакте </td>
        <td class="comment">Комментарий</td>
    </tr>

    <logic:iterate id="user" name="Records" property="users">
        <tr>
            <td><bean:write name="user" property="from"/> </td>
            <td><bean:write name="user" property="where"/> </td>
            <td><bean:write name="user" property="day" format=""/> </td>
            <td><bean:write name="user" property="month" format=""/> </td>
            <td><a href="<bean:write name="user" property="vkId"/>"> VK</a></td>
            <td><bean:write name="user" property="comment"/> </td>
        </tr>
    </logic:iterate>
</table>
