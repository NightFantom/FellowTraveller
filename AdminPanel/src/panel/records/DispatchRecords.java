package panel.records;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import panel.CheckUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Класс предназначен для возвращения маршрутов из БД
 */
public class DispatchRecords extends DispatchAction {
    public static final String FORWARD_NEW_RECORDS = "newRecord";
    public static final String FORWARD_ALL_RECORDS = "allRecord";
    public static final String FORWARD_ERROR = "error";



    /**
     * Метод возвращает все записи, занесённые за указанный период
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward newRecords (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (CheckUser.logon(request)){

            return mapping.findForward(FORWARD_NEW_RECORDS);
        }else {
            return mapping.findForward(FORWARD_ERROR);
        }
    }

    /**
     * Метод возвращает все записи
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward allRecords (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (CheckUser.logon(request)){

            return mapping.findForward(FORWARD_ALL_RECORDS);
        }else {
            return mapping.findForward(FORWARD_ERROR);
        }
    }
}
