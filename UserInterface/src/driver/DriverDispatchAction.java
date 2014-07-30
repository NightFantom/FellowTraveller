package driver;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Виктор on 02.05.2014.
 */
public class DriverDispatchAction extends DispatchAction {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        DriverActionForm driverActionForm = (DriverActionForm) form;

            return mapping.findForward("success");

   //  return mapping.findForward("error");
    }
}