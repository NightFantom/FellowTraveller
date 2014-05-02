package RedirectOnDriverOrPassengerPage;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Виктор on 02.05.2014.
 * класс направляет на форму водителя или пассажира взависимоти от выбора пользователя
 */
public class SelectDirectDispatchAction extends DispatchAction {

    public static final String FORWARD_DRIVER = "driver";
    public static final String FORWARD_PASSENGER = "passenger";
    public static final String FORWARD_ERROR = "error";

    /**
     * метод перенаправления на форму водителя
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward driver(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        return mapping.findForward(FORWARD_DRIVER);
    }

    /**
     * метод перенаправления на форму пассажира
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward passenger(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        return mapping.findForward(FORWARD_PASSENGER);
    }
}