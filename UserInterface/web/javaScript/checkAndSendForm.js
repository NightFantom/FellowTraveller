/**
 * Created by Виктор on 20.05.2014.
 */
function checkAndSend(url, form, id) {
    if (formIsCorrect(form)) {
        postAjax(url, form, id);
    }
}