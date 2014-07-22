<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 07.05.2014
  Time: 16:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <%@include file="DriverAndPassengerPage/header.jsp" %>
    <script type="text/javascript" src="javaScript/ajax.js"></script>
    <script type="text/javascript" src="javaScript/checkForm.js"></script>
    <title>Я водитель</title>
</head>
<body>
<div id="basis">
    <div id="mainMenu">
        <div id="topRectangle"></div>
        <div id="center">
            <div class="menuBlock"><a href="${pageContext.request.contextPath}/index.do"><img src="images/logo.png"></a></div>
            <div class="form">
                <form>
                    <p>Откуда* <input class="textInput" type="text" name="from" id="from"
                                     onkeyup="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"
                                     onkeypress="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"
                                     onchange="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"
                                     placeholder="Город отправления"
                                     maxlength="25"> </p>

                    <p>Куда* <input class="textInput" type="text" name="where" id="where"
                                   onkeyup="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"
                                   onkeypress="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"
                                   onchange="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"
                                   placeholder="Город прибытия"
                                   maxlength="25"></p>

                    <p>Когда*
                        <select class="date" name="day" id="date"
                                onkeyup="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"
                                onkeypress="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"
                                onchange="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                            <option value="24">24</option>
                            <option value="25">25</option>
                            <option value="26">26</option>
                            <option value="27">27</option>
                            <option value="28">28</option>
                            <option value="29">29</option>
                            <option value="30">30</option>
                            <option value="31">31</option>
                        </select>
                        <select class="date" name="month" id="month"
                                onkeyup="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"
                                onkeypress="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"
                                onchange="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')">
                            <option value="1">Янв</option>
                            <option value="2">Фев</option>
                            <option value="3">Март</option>
                            <option value="4">Апр</option>
                            <option value="5">Май</option>
                            <option value="6">Июн</option>
                            <option value="7">Июл</option>
                            <option value="8">Авг</option>
                            <option value="9">Сен</option>
                            <option value="10">Окт</option>
                            <option value="11">Ноя</option>
                            <option value="12">Дек</option>
                        </select>
                    </p>

                    <p>Страница в ВК* <input class="textInput" type="text" name="vkId" id="vkId"
                                            onkeyup="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"
                                            onkeypress="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"
                                            onchange="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"
                                            placeholder="vk.com/..."
                                            maxlength="25"></p>

                    <p>Комментарий <textarea name="comment" id="comment"
                                             onkeyup="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"
                                             onkeypress="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"
                                             onchange="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"
                                             placeholder="Ваш комментарий"
                                             maxlength="1000"
                                             onkeydown="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')">

                                             </textarea></p>
                    <p id="commentMessage"> </p>

                  <p class="agreement">

                        <input id="agree" type="checkbox" name="agree" onclick="checkDriverForm('from','where','date','month','agree','vkId','comment','button','commentMessage')"  >
                        <a href="${pageContext.request.contextPath}/agreement.do">Принимаю условия соглашения*</a></p>

                    <input id="button" type="button" class="textInput" value="Поехали" disabled="disabled"
                           onclick="postAjax('${pageContext.request.contextPath}/save.do',document.forms[0],'serverAnswer')">
                </form>
                <p style="font-size: 12pt; color: black;">* - поля обязательные для заполнения</p>
                <div id="serverAnswer"></div>
            </div>
            <%@include file="DriverAndPassengerPage/footer.jsp" %>
