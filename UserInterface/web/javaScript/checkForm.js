/**
 * Created by Виктор on 20.05.2014.
 */
function formIsCorrect() {
    var arrayOfElementsOfForm = getArrayOfElements();
    var successful = false;
    for (var i = 0; i < arrayOfElementsOfForm.length; i++) {
        switch (arrayOfElementsOfForm[i].type) {
            case 'checkbox':
                if (arrayOfElementsOfForm[i].value == 'agree') {
                    successful = true;
                } else {
                    successful = false;
                }

                break;

            default:
                if (arrayOfElementsOfForm[i].value != "" && arrayOfElementsOfForm[i].value != null) {
                    successful = true;
                } else {
                    successful = false;
                }
                break;
        }
        if (!successful) {
            document.getElementById(arrayOfElementsOfForm[i].id).innerHTML = "Введите данные!!";
            return;
        }


    }
    return successful;
}