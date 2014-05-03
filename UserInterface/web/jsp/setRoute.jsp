<%--
  Created by IntelliJ IDEA.
  User: Виктор
  Date: 02.05.2014
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
var request = null;
function createRequest(){
try{
request = new XMLHttpRequest();
}catch(trymicrosoft) {
try{
request = new ActiveXObject("Msxm13.XMLHTTP");
}catch (othermicrosoft){
try{
request = new ActiveXObject("Microsoft.XMLHTTP");
}catch (failed){
request = null;
}
}
}
if(request==null){
alert("Error creating request object")
}
}
function updatePage() {
if (request.readyState == 4) {
var newDriver = request.responseText;
var driverList = document.getElementById("idDriver");
replaceText(newDriver, newDriver);
}
}
function getDrivers () {
createRequest();
var url = "adress";
request.open("GET",url,true);
request.onreadystatechange = updatePage;
request.send(null);
}
</body>
</html>
