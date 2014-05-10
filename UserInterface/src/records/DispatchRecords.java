package records;

import hibernateServise.HibernateUtil;
import hibernateServise.RecordsForm;
import hibernateServise.User;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Класс предназначен для возвращения маршрутов из БД
 */
public class DispatchRecords extends DispatchAction {

    public static final String FORWARD_LIST_RECORDS = "successful";
    public static final String FORWARD_SAVE_RECORD = "successful";

    @Override
    protected String getMethodName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, String parameter) throws Exception {
        return parameter;
    }


    /**
     * Метод заносит данные из формы в БД
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward saveRecords(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        User user = (User) form;
        HibernateUtil hibernateUtil = new HibernateUtil();
        try {
            Session session = hibernateUtil.currentSession();
            Transaction transaction = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            hibernateUtil.close();
        }
        return mapping.findForward(FORWARD_SAVE_RECORD);

    }


    public ActionForward getSpecificRecords(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        RecordsForm routesForm = (RecordsForm) form;
        routesForm.getUser();
        HibernateUtil hibernateUtil = new HibernateUtil();
        try {
            Session session = hibernateUtil.currentSession();
            Criteria criteria = session.createCriteria(User.class);
            if (routesForm.getFrom() != null) {
                criteria.add(Restrictions.like("from", routesForm.getFrom()));
            }
            if (!routesForm.getWhere().equals("")) {
                criteria.add(Restrictions.like("where", routesForm.getWhere()));
            }
            Integer day = routesForm.getDay();
            if (day != null && day.compareTo(new Integer(0)) != 0) {
                criteria.add(Restrictions.like("day", routesForm.getDay()));
            }
            Integer month = routesForm.getMonth();
            if (month != null && month.compareTo(new Integer(0)) != 0) {
                criteria.add(Restrictions.like("month", routesForm.getMonth()));
            }
            routesForm.setUsers(criteria.list());
        } catch (Exception e) {
            throw e;
        } finally {
            hibernateUtil.close();
        }
        return mapping.findForward(FORWARD_LIST_RECORDS);
    }
}
