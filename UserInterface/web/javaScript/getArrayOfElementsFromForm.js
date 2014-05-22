/**
 * Created by Виктор on 20.05.2014.
 */

function getElementsFromForm(form) {
    var successful= false;
    var elements = [];
    var currentElement;
 //   var radio_groups = {}; // Эта переменная служит для учета групп радиокнопок
    for (var i = 0; i < form.length; i++) {
        var temporaryElement = form[i];
        switch (temporaryElement.type) {

            // Закомментил из-за того, что данный случай может пригодиться в будущем, но в данный момент мы не используем radio.
            // Закомментированная часть полностью работоспособна
//
//          case 'radio' :
//                if (temporaryElement.checked) {
//                    radio_groups[temporaryElement.name] = '[filled]'; // помечаем группу
//                    currentElement = {name: temporaryElement.name,id: temporaryElement.id, type: 'radio', value: temporaryElement.value};
//                } else {
//                    if (!radio_groups[temporaryElement.name]) { // если группа еще не встречалась
//                        radio_groups[temporaryElement.name] = '[no elelements checked]';
//                    }
//                    continue;
//                }
//                break;
            case 'checkbox' :
                if (temporaryElement.checked) {
                    successful=true;
                } else {
                    currentElement = {name: temporaryElement.name, id: temporaryElement.id, type: 'checkbox', value: '[not checked]'};
                }
                break;
            default:
                currentElement = {name: temporaryElement.name, id: temporaryElement.id, type: temporaryElement.type, value: temporaryElement.value};
                break;
        }
        elements.push(currentElement);
    }
    // Отдельная обработка всех radio groups
//    for (var rg in radio_groups) {
//        if (radio_groups[rg] != '[filled]') { //добавляем группу, в которой нет выбранных кнопок
//            elements.push({name: rg, type: 'radio', value: radio_groups[rg]});
//        }
//    }
    return elements;
}

function getArrayOfElements(form) {
    var forms = form;
    var elements = [];
    for (var i = 0; i < forms.length; i++) {
        elements[i] = getElementsFromForm(forms[i]);
    }
    return elements;
}