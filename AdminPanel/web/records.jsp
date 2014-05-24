<%@include file="header.jsp"%>
<input type="button" onclick="getDrivers('${pageContext.request.contextPath}/protected/getallrecords.do?table=route', 'post', 'data')" value="Просмотр всех записей">
<input type="button" onclick="getDrivers('${pageContext.request.contextPath}/protected/getallrecords.do?table=routebuf', 'post', 'data')" value="Просмотр новых записей">
<div id = "data"></div>
<%@include file="footer.jsp"%>