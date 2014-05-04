<%@include file="header.jsp"%>
<input type="button" onclick="getDrivers('${pageContext.request.contextPath}/getrecords.do?get=allRecords', 'post', 'data')" value="Просмотр всех записей">
<div id = "data"></div>
<%@include file="footer.jsp"%>