<%--
  Created by IntelliJ IDEA.
  User: Виктор
  Date: 01.05.2014
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>

    <title>Driver panel</title>
</head>
<body>
<div align = "center">

        <form action="${pageContext.request.contextPath}/driverform.do" method="post">
            <p>From <input type="text" name="from"></p>
            <p>Where <input type="text" name="where"></p>
            <p>When <input type="text" name="when"></p>
            <p>e-mail <input type="text" name="mail"></p>
            <p>Id <input type="text" name="vkId"></p>
            <p>Comment <input type="text" name="comment"></p>
           <input type="submit" value="Enter">
        </form>

</div>

</body>
</html>
