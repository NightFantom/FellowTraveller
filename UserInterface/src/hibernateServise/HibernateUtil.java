package hibernateServise;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {

    private  final SessionFactory sessionFactory = buildSessionFactory();
    private ServiceRegistry serviceRegistry;
    private  final ThreadLocal session = new ThreadLocal();



    private SessionFactory buildSessionFactory() {
        SessionFactory sf;
        try {
            Configuration configuration = new Configuration().configure();
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sf = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            throw new ExceptionInInitializerError(ex);
        }
        return sf;
    }

    public Session currentSession() throws HibernateException {
        Session s = (Session) session.get();
        // Open a new Session, if this Thread has none yet
        if (s == null) {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }

    public  void close(){
        if(serviceRegistry!= null) {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
        Session s = (Session) session.get();
        session.set(null);
        if (s != null){
            s.close();
        }
    }

}