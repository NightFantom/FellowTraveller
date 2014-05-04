package panel.settings;

import com.mysql.jdbc.*;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.BaseAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.sql.Connection;
import java.sql.Driver;

/**
 * Created by Денис on 03.05.14.
 * Класс разворачивает новую таблицу для хранения маршрутов
 */
public class CreateTable extends BaseAction{

    private static final String URL = "jdbc:mysql://localhost:3306/fellowtraveller?useUnicode=true&characterEncoding=utf-8";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";
    private static final String FORWARD_SETTINGS = "settings";

    /**
     * Метод отправляет запрос на создание таблицы
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        MessageForm messageForm = (MessageForm) form;

        Driver driver = new com.mysql.jdbc.Driver();
        DriverManager.registerDriver(driver);

        Connection connection = null;
        ResultSet cursor = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            String send = "CREATE TABLE `route`  ( \n" +
                    "\t`id`     \tint(11) NOT NULL AUTO_INCREMENT,\n" +
                    "\t`from`   \tvarchar(25) NOT NULL,\n" +
                    "\t`where`  \tvarchar(25) NOT NULL,\n" +
                    "\t`day` integer(11) NOT NULL,\n" +
                    "\t`month` integer(11) NOT NULL,\n"+
                    "\t`mail`   \tvarchar(25) NOT NULL,\n" +
                    "\t`vkId`   \tvarchar(25) NOT NULL,\n" +
                    "\t`comment`\tvarchar(100) NULL,\n" +
                    "\t`time`\ttimestamp NOT NULL,\n "+
                    "\tPRIMARY KEY(`id`)\n" +
                    ")\n" +
                    "ENGINE = MyISAM\n" +
                    "CHARACTER SET utf8\n" +
                    "COLLATE utf8_general_ci\n" +
                    "AUTO_INCREMENT = 0";
            connection.createStatement().execute(send);
            messageForm.setMessage("Таблица создана успешно");
        }catch (SQLException e){
            messageForm.setMessage("Не удалось создать таблицу \n" + e.getMessage());
        }
        finally {
            if (cursor != null)
            {
                cursor.close();
            }
            if (connection != null)
            {
                connection.close();
            }
        }

        return mapping.findForward(FORWARD_SETTINGS);
    }
}
