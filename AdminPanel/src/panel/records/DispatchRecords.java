package panel.records;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import panel.CheckUser;
import hibernateServise.HibernateUtil;
import hibernateServise.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.Expression;
import java.util.List;

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
            RecordsForm routesForm = (RecordsForm) form;
            HibernateUtil hibernateUtil = new HibernateUtil();
            try {
                Session session = hibernateUtil.currentSession();
                Transaction transaction = session.beginTransaction();
                routesForm.setUsers(session.createCriteria(User.class).list());
                session.getTransaction().commit();
            }catch (Exception e){
                throw e;
            }finally {
                hibernateUtil.close();
            }
            return mapping.findForward(FORWARD_ALL_RECORDS);
        }else {
            return mapping.findForward(FORWARD_ERROR);
        }
    }

    public ActionForward specificRecords (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (CheckUser.logon(request)){
            RecordsForm routesForm = (RecordsForm) form;
            User user = routesForm.getUser();
            HibernateUtil hibernateUtil = new HibernateUtil();
            try {
                Session session = hibernateUtil.currentSession();
                Criteria criteria =  session.createCriteria(User.class);
                criteria.add(Restrictions.like("from",user.getFrom()));
                criteria.add(Restrictions.like("where",user.getWhere()));
                List<User> list = criteria.list();
                routesForm.setUsers(list);
            }catch (Exception e){
                throw e;
            }finally {
                hibernateUtil.close();
            }
            return mapping.findForward(FORWARD_ALL_RECORDS);
        }else {
            return mapping.findForward(FORWARD_ERROR);
        }
    }
}
