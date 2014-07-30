/**
 * функция для работы с различными браузерами
 * @returns {*}
 */

function createXMLHttp() {
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

/**
 * фукнция автоматической упаковки формы любой сложности
 * @param oForm
 * @returns {string}
 */
function getRequestBody(oForm) {
    var aParams = new Array();
    for (var i = 0; i < oForm.elements.length; i++) {
        var sParam = encodeURIComponent(oForm.elements[i].name);
        sParam += "=";
        sParam += encodeURIComponent(oForm.elements[i].value);
        aParams.push(sParam);
    }
    return aParams.join("&");
}

function startFading(){ //Начать угасание
    while(document.getElementById('routeAdd').style.opacity!= 0){
        setTimeout("document.getElementById('routeAdd').style.opacity -= 0.1 ",200);
    }
    document.getElementById('routeAdd').innerHTML='';
}

function startTimer() { // Старт таймера
    document.getElementById('routeAdd').style.opacity = 1;
    setTimeout(startFading,3000)
}

/**
 * функция отправки формы и получения ответа от сервера
 * @param url адрес запроса
 * @param oForm форма которую надо отправить, можно просто прописать document.forms[0]
 * @param id то место в html документе, где будет отображен ответ сервера
 */
function postAjax(url, oForm, id) {
    var oXmlHttp = createXMLHttp();
    var sBody = getRequestBody(oForm);
    document.getElementById(id).innerHTML = '<img src="images/ajaxloaderblack.gif" >';
    oXmlHttp.open("POST", url, true);
    oXmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    oXmlHttp.onreadystatechange = function () {
        if (oXmlHttp.status == 200 && oXmlHttp.readyState == 4) {             // Если все ок, то выдаем ответ сервера
            document.getElementById(id).innerHTML = oXmlHttp.responseText;
            startTimer();
        } else {
            document.getElementById(id).innerHTML = "ajax error";
        }
    };
    oXmlHttp.send(sBody);
}
