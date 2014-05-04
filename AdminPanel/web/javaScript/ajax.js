/**
 * Created by Денис on 04.05.14.
 */

function getXmlHttp() {
    var xmlhttp;
    try {
        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {
        try {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (E) {
            xmlhttp = false;
        }
    }
    if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
        xmlhttp = new XMLHttpRequest();
    }
    return xmlhttp;
}

function updatePage() {

}
function getDrivers() {
    var req = getXmlHttp();
    var statusElem = document.getElementById('data');
    req.onreadystatechange = function () {
        // onreadystatechange активируется при получении ответа сервера
        if (req.readyState == 4) {
            // если запрос закончил выполняться

            statusElem.innerHTML = req.statusText // показать статус (Not Found, ОК..)

            if (req.status == 200) {
                // если статус 200 (ОК) - выдать ответ пользователю
                statusElem.innerHTML = req.responseText;
            }
            // тут можно добавить else с обработкой ошибок запроса
        }

    }

    req.open('get', '/adminpanel/getrecords.do?get=allRecords', true);
    // req.onreadystatechange = updatePage;
    req.send(null);
    statusElem.innerHTML = 'Ожидаю ответа сервера...'
}

