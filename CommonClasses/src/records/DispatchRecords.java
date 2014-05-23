package records;

import hibernateServise.RecordsForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernateServise.HibernateUtil;
import hibernateServise.User;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Класс предназначен для возвращения маршрутов из БД
 */
public class DispatchRecords extends DispatchAction {
    public static final String FORWARD_NEW_RECORDS = "newRecord";
    public static final String FORWARD_LIST_RECORDS = "listRecord";
    public static final String FORWARD_SAVE_RECORD = "successful";


    @Override
    protected String getMethodName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, String parameter) throws Exception {
        return parameter;
    }

    /**
     * Метод возвращает все записи, занесённые за указанный период
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward newRecords(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        return mapping.findForward(FORWARD_NEW_RECORDS);
    }

    /**
     * Метод возвращает все записи
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward allRecords(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        RecordsForm routesForm = (RecordsForm) form;
        try {
            Session session = HibernateUtil.currentSession();
            Transaction transaction = session.beginTransaction();
            routesForm.setUsers(session.createCriteria(User.class).list());
            session.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
        return mapping.findForward(FORWARD_LIST_RECORDS);
    }

    /**
     * Метод сохраняет данные о маршруте
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward saveRecords(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = (User) form;
        user.setMail("");
        try {
            Session session = HibernateUtil.currentSession();
            Transaction transaction = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
        return mapping.findForward(FORWARD_SAVE_RECORD);

    }

    /**
     * Метод получает все маршруты, соответствующие критериям из form
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward getSpecificRecords(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        RecordsForm routesForm = (RecordsForm) form;
        User user = routesForm.getUser();
        try {
            Session session = HibernateUtil.currentSession();
            Transaction transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            if (!user.getFrom().equals("")) {
                criteria.add(Restrictions.like("from", user.getFrom()));
            }
            if (!user.getWhere().equals("")) {
                criteria.add(Restrictions.like("where", user.getWhere()));
            }
            Integer day = user.getDay();
            if (day != null && day.compareTo(new Integer(0)) != 0) {
                criteria.add(Restrictions.like("day", user.getDay()));
            }
            Integer month = user.getMonth();
            if (month != null && month.compareTo(new Integer(0)) != 0) {
                criteria.add(Restrictions.like("month", user.getMonth()));
            }
            routesForm.setUsers(criteria.list());
            transaction.commit();
        } catch (Exception e) {
            throw e;
        }
        return mapping.findForward(FORWARD_LIST_RECORDS);

    }
}
