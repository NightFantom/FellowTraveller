/**
 * @created Виктор
 * @returns {*}
 */

function createXMLHttp() {  //getXmlHttp
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
//
//
///**
// *
// * @param path  URL запроса
// * @param id ID блока, куда будет подгружаться страница
// */
//function updatePage(path, id) {
//    var req = getXmlHttp();
//    var statusElem = document.getElementById(id);
//    req.onreadystatechange = function () { // onreadystatechange активируется при получении ответа сервера
//
//        if (req.readyState == 4) {  // если запрос закончил выполняться
//             statusElem.innerHTML = req.statusText // показать статус (Not Found, ОК..)
//
//            if (req.status == 200) { // если статус 200 (ОК) - выдать ответ пользователю
//
//                statusElem.innerHTML = req.responseText;
//            }
//
//        }
//
//    }
//
//    req.open("GET", path, true);
//    // req.onreadystatechange = updatePage;
//    req.send();
//    statusElem.innerHTML = 'Ожидаю ответа сервера...'
//}
//function createXMLHttp(){
//    if	(typeof XMLHttpRequest != "undefined") { // для браузеров аля Mozilla
//        return new XMLHttpRequest();
//    } else if (window.ActiveXObject) { // для Internet Explorer (all versions)
//        var aVersions = [
//            "MSXML2.XMLHttp.5.0",
//            "MSXML2.XMLHttp.4.0",
//            "MSXML2.XMLHttp.3.0",
//            "MSXML2.XMLHttp",
//            "Microsoft.XMLHttp"
//        ];
//        for (var i = 0; i < aVersions.length; i++) {
//            try {
//                var oXmlHttp = new ActiveXObject(aVersions[i]);
//                return oXmlHttp;
//            } catch (oError) {}
//        } throw new Error("Невозможно создать объект XMLHttp.");
//    }}

// фукнция Автоматической упаковки формы любой сложности
function getRequestBody(oForm) {
    var aParams = new Array();
    for(var i = 0; i < oForm.elements.length; i++) {
        var sParam = encodeURIComponent(oForm.elements[i].name);
        sParam += "=";
        sParam += encodeURIComponent(oForm.elements[i].value);
        aParams.push(sParam);
    }
    return aParams.join("&");
}
//function showResult(d) {
//    document.getElementById(id).innerHTML=d;
//}

function postAjax(url,oForm,id) { // функция Ajax POST
    var oXmlHttp = createXMLHttp();
    var sBody = getRequestBody(oForm);

    oXmlHttp.open("POST",url,true);
    oXmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    oXmlHttp.onreadystatechange = function() {
        if(oXmlHttp.readyState == 4) {
            if(oXmlHttp.status == 200) {
                document.getElementById(id).innerHTML=oXmlHttp.responseText;
            } else {
                document.getElementById(id).innerHTML="error";
            }
        }
    };
    oXmlHttp.send(sBody);
}


