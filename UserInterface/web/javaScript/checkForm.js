/**
 * Created by Виктор on 20.05.2014.
 */

function formIsCorrect(form, id) {
//    var success= false;
//    var currentElement;
//    document.getElementById(id).innerHTML = '<img src="images/ajaxloaderwheel.gif" >';
//    for (var i = 0; i < form.length; i++) {
//        var temporaryElement = form[i];
//        switch (temporaryElement.type) {
//
//            case 'checkbox' :
//                if (temporaryElement.checked) {
//                    success=true;
//                } else {
//                    success=false;
//                    return;
//                }
//                break;
//            default:
//                if( currentElement.value.toString()!="" &&currentElement.value.toString()!=null){
//                    success=true;
//                 }else{
//                    success=false;
//                    return;
//                }
//                 break;
//        }
//
//    }
//    return success;
    var element = form.getElementById("from");
    if(element==""){
        form.getElementById(id).innerHTML = '<img src="images/ajaxloaderwheel.gif" >';
    }
}

//function getBody(oForm,id) {
//    var success= false;
//   // var aParams = new Array();
//    for (var i = 0; i < oForm.elements.length; i++) {
////        var sParam = encodeURIComponent(oForm.elements[i].name);
////        sParam += "=";
////        sParam += encodeURIComponent(oForm.elements[i].value);
//        if(oForm.elements[i].value!=""&&oForm.elements[i].value!=null){
//            success=true;
//        }else{
//            var success= false;
//            return;
//        }
//   //     aParams.push(sParam);
//    }
//    if(!success){
//        document.getElementById(id).innerHTML = '<img src="images/ajaxloaderwheel.gif" >';
//    }
//    document.getElementById(id).innerHTML = '<img src="images/ajaxloaderwheel.gif" >';
////    return aParams.join("&");
//}
