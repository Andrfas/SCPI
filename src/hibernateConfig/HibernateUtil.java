package hibernateConfig;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by Andrey on 24.02.2015.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new AnnotationConfiguration()
                    .addAnnotatedClass(entities.employees.Employee.class)
                    .addAnnotatedClass(entities.employees.EmployeeGroup.class)
                    .configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log exception!
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession()
            throws HibernateException {
        return sessionFactory.openSession();
    }

    public static SessionFactory getSessionFactory()
            throws HibernateException {
        return sessionFactory;
    }
}
