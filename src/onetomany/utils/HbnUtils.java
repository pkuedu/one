package onetomany.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by user on 17-3-31.
 */
public class HbnUtils {
    private static SessionFactory sessionFactory;
    public static Session getSession(){
        sessionFactory = getSessionFactory();
        return sessionFactory.getCurrentSession();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null || sessionFactory.isClosed()) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
