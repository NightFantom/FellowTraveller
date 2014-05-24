package records;

import hibernateServise.*;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Класс предназначен для возвращения маршрутов из БД
 */
public class DispatchRecords extends DispatchAction {
    public static final String FORWARD_NEW_RECORDS = "newRecords";
    public static final String FORWARD_LIST_RECORDS = "listRecords";
    public static final String FORWARD_SAVE_RECORD = "successful";
    public static final String FORWARD_ERROR = "error";
    private  static final String BUF_TABLE = "routebuf";
    private  static final String TABLE = "route";

    @Override
    protected String getMethodName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, String parameter) throws Exception {
        return parameter;
    }

    /**
     * Метод удаляет запись из БД
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        RecordsForm routesForm = (RecordsForm) form;
        User user = new User();
        user.setId(routesForm.getId());
        String table = request.getParameter("table");
        try {
            Session session = ((SessionFactory) servlet.getServletContext().getAttribute(HibernatePlugin.KEY_NAME)).getCurrentSession();
            session.beginTransaction();
            session.delete(table,user);
            routesForm.setUsers(session.createCriteria(table).list());
            session.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
        if (table.equals(TABLE)){
            return mapping.findForward(FORWARD_LIST_RECORDS);
        }else {
            return mapping.findForward(FORWARD_NEW_RECORDS);
        }
    }

    /**
     * Метод переносит данные из буферной таблицы в исходную
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward approve(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        RecordsForm routesForm = (RecordsForm) form;
        User user = new User();
        user.setId(routesForm.getId());
        try {
            Session session = ((SessionFactory) servlet.getServletContext().getAttribute(HibernatePlugin.KEY_NAME)).getCurrentSession();
            session.beginTransaction();
            user = (User) session.load(BUF_TABLE,user.getId());
            session.delete(BUF_TABLE,user);
            session.save(TABLE, user);
            routesForm.setUsers(session.createCriteria(BUF_TABLE).list());
            session.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
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
        String table = (String)request.getParameter("table");
        try {
            Session session = ((SessionFactory) servlet.getServletContext().getAttribute(HibernatePlugin.KEY_NAME)).getCurrentSession();
            session.beginTransaction();
            routesForm.setUsers(session.createCriteria(table).list());
            session.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
        if (table.equals(TABLE)){
            return mapping.findForward(FORWARD_LIST_RECORDS);
        }else {
            return mapping.findForward(FORWARD_NEW_RECORDS);
        }

    }

    /**
     * Метод сохраняет данные о маршруте
     *
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
        if (user != null && CheckRecords.driverFormIsCorrect(user)) {
            try {
                Session session = ((SessionFactory) servlet.getServletContext().getAttribute(HibernatePlugin.KEY_NAME)).getCurrentSession();
                session.beginTransaction();
                session.save("routebuf", user);
                session.getTransaction().commit();
            } catch (Exception e) {
                throw e;
            }
            return mapping.findForward(FORWARD_SAVE_RECORD);
        } else {
            return mapping.findForward(FORWARD_ERROR);

        }
    }

    /**
     * Метод получает все маршруты, соответствующие критериям из form
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward getSpecificRecords(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        RecordsForm routesForm = (RecordsForm) form;
        User user = new User();
        user.setFrom(routesForm.getFrom());
        user.setWhere(routesForm.getWhere());
        user.setDay(routesForm.getDay());
        user.setMonth(routesForm.getMonth());
        user.setAgree(routesForm.getAgree());
        if (user != null && CheckRecords.passengerFormIsCorrect(user)) {
            try {
                Session session = ((SessionFactory) servlet.getServletContext().getAttribute(HibernatePlugin.KEY_NAME)).getCurrentSession();
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
        } else {
            return mapping.findForward(FORWARD_ERROR);
        }

    }
}
