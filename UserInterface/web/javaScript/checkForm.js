/**
 * Created by Виктор on 24.05.2014.
 */

function isConsistOfRussianLetters(s) {
    var i;

    for (i = 0; i < s.length; i++) {
        if ('а'.charCodeAt(0) <= s.charCodeAt(i) && s.charCodeAt(i) <= 'я'.charCodeAt(0) ||
            'А'.charCodeAt(0) <= s.charCodeAt(i) && s.charCodeAt(i) <= 'Я'.charCodeAt(0)) {

        } else {
            return false;
        }
    }
    return true;
}

function recordIsCorrect(s) {
    if (s != "" && s != null && isConsistOfRussianLetters(s)) {
        return true;
    }
    return false;
}

function dateIsCorrect(day, month) {
    if (day != null && month != null) {
        if (1 <= day && day <= 31) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (1 <= day && day <= 31) {
                        return true;
                    }
                    return false;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (1 <= day && day <= 30) {
                        return true;
                    }
                    return false;
                case 2:
                    if (1 <= day && day <= 28) {
                        return true;
                    }
                    return false;
                default:
                    return false;
            }

        }
    }
    return false;
}

function recordVKidIsCorrect(vkId) {
    if (vkId.indexOf("http://vk.com/") == 0 || vkId.indexOf("vk.com/") == 0) {
        return true;
    }
    return false;
}

function doesNotExceed(s, length) {
    if (s.length <= length) {
        return true;
    }
    return false;
}

function isCoincides(s, expectedValue) {
    if (s != null && s == expectedValue) {
        return true;
    }
    return false;
}

function passengerFormIsCorrect(fromId, whereId, dateId, monthId, agreeId) {
    var from = document.getElementById(fromId);
    var where = document.getElementById(whereId);
    var day = document.getElementById(dateId);
    var month = document.getElementById(monthId);
    var agree = document.getElementById(agreeId);
    if (recordIsCorrect(from.value) && recordIsCorrect(where.value) && dateIsCorrect(parseInt(day.value), parseInt(month.value))
        && isCoincides(agree.value, 'true')) {
        return true;
    }
    return false;
}

function driverFormIsCorrect(fromId, whereId, dateId, monthId, agreeId, vkIdId, commentId) {
    var from = document.getElementById(fromId);
    var where = document.getElementById(whereId);
    var date = document.getElementById(dateId);
    var month = document.getElementById(monthId);
    var agree = document.getElementById(agreeId);
    var vkId = document.getElementById(vkIdId);
    var comment = document.getElementById(commentId);
    if (recordIsCorrect(from.value) && recordIsCorrect(where.value) && dateIsCorrect(parseInt(date.value), parseInt(month.value))
        && recordVKidIsCorrect(vkId.value) && doesNotExceed(comment.value, 100) && isCoincides(agree.value, 'true')) {
        return true;
    }
    return false;
}

function checkPassengerForm(fromId, whereId, dateId, monthId, agreeId, buttonId) {
    var from = document.getElementById(fromId);
    var where = document.getElementById(whereId);
    var date = document.getElementById(dateId);
    var month = document.getElementById(monthId);
    var agree = document.getElementById(agreeId);
    var button = document.getElementById(buttonId);
    if (agree.checked) {
        agree.value = 'true';
    } else {
        agree.value = '';
    }
    passengerFormIsCorrect(fromId, whereId, dateId, monthId, agreeId) ? button.disabled = false : button.disabled = true;
}

function checkDriverForm(fromId, whereId, dateId, monthId, agreeId, vkIdId, commentId, buttonId) {
    var from = document.getElementById(fromId);
    var where = document.getElementById(whereId);
    var date = document.getElementById(dateId);
    var month = document.getElementById(monthId);
    var agree = document.getElementById(agreeId);
    var vkId = document.getElementById(vkIdId);
    var comment = document.getElementById(commentId);
    var button = document.getElementById(buttonId);
    if (agree.checked) {
        agree.value = 'true';
    } else {
        agree.value = '';
    }
    driverFormIsCorrect(fromId, whereId, dateId, monthId, agreeId, vkIdId, commentId) ? button.disabled = false : button.disabled = true;
}