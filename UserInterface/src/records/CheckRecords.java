package records;

/**
 * Created by Виктор on 22.05.2014.
 */

/**
 * Класс для проверки поля из формы
 */
public class CheckRecords {
    /**
     * Проверка на содержание латинской буквы
     * @param s - строка
     * @return true если есть хотя бы одно вхождение латинской буквы
     */
    private boolean hasLatinLetters(String s) {
        char [] buf = new char[s.length()];
        s.getChars(0,s.length(),buf,0);
        for (int i=0;i<s.length();i++){
            if('a'<=buf[i]&&buf[i]<='z' ||'A'<=buf[i]&&buf[i]<='Z'){
                return true;
            }
        }
        return false;
    }

    /**
     * Метод проверки на кореектность данных поля from
     * @param from откуда
     * @return true если строка не пустая и не имеет вхождения латинских букв
     */
    public boolean recordFromIsCorrect(String from) {
        if (!from.equals("") && from != null && !hasLatinLetters(from)) {
            return true;
        }
        return false;
    }

    /**
     * Метод проверки на корректность данных поля where
     * @param where куда
     * @return true если строка не пустая и не имеет вхождения латинских букв
     */
    public boolean recordWhereIsCorrect(String where) {
        if (!where.equals("") && where != null && !hasLatinLetters(where)) {
            return true;
        }
        return false;
    }

    /**
     * Метод проверки на корректность данных полей day и month
     * @param day день
     * @param month месяц
     * @return
     */
    public boolean recordDateIsCorrect(Integer day, Integer month) {
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

    /**
     * Метод проверки на корректность данных поля vkId
     * @param vkId ссылка на страницу в соц сети ВКонтакте
     * @return
     */
    public boolean recordVKidIsCorrect(String vkId) {

        if ( vkId.indexOf("http://vk.com/") == 0 ||  vkId.indexOf("vk.com/") == 0) {
            return true;
        }
        return false;

    }

    /**
     * Метод проверки на корректность данных поля comment
     *
     * @param comment
     * @return true всегда //надо дописать на проверку длины строки
     */
    public boolean recordCommentIsCorrect(String comment) {
        return true;
    }

    /**
     * Метод проверки на корректность данных поля agree
     * @param agree
     * @return true если пользователь принял условия соглашения
     */
    public boolean userIsAgree(String agree) {
        if (agree != null && agree.equals("true")) {
            return true;
        }
        return false;
    }
}
