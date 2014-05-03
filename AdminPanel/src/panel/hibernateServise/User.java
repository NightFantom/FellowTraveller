package panel.hibernateServise;

import org.apache.struts.action.ActionForm;

/**
 * Created by Денис on 03.05.2014.
 * Форма пользователя
 */

public class User extends ActionForm {
    private Integer id;
    private String from;
    private String where;
    private String when;
    private String mail;
    private String vkId;
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return Откуда
     */
    public String getFrom() {
        return from;
    }

    /**
     *
     * @param from Откуда
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     *
     * @return Куда
     */
    public String getWhere() {
        return where;
    }

    /**
     *
     * @param where Куда
     */
    public void setWhere(String where) {
        this.where = where;
    }

    /**
     *
     * @return Когда
     */
    public String getWhen() {
        return when;
    }

    /**
     *
     * @param when Когда
     */
    public void setWhen(String when) {
        this.when = when;
    }

    /**
     *
     * @return Почта
     */
    public String getMail() {
        return mail;
    }

    /**
     *
     * @param mail Почта
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     *
     * @return id Вконтакте
     */
    public String getVkId() {
        return vkId;
    }

    /**
     *
     * @param vkId id Вконтакте
     */
    public void setVkId(String vkId) {
        this.vkId = vkId;
    }

    /**
     *
     * @return Комментарий
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment Комментарий
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
