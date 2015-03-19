package configurations;

import model.entities.artifacts.*;
import model.entities.dossiers.Dossier;
import model.entities.employees.Employee;
import model.entities.employees.EmployeeGroup;
import model.entities.employees.GroupActions;
import model.entities.employees.LoginData;
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
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(EmployeeGroup.class)
                    .addAnnotatedClass(LoginData.class)
                    .addAnnotatedClass(GroupActions.class)

                    .addAnnotatedClass(Action.class)
                    .addAnnotatedClass(Artifact.class)
                    .addAnnotatedClass(ArtifActionType.class)
                    .addAnnotatedClass(ArtifactType.class)
                    .addAnnotatedClass(Field.class)
                    .addAnnotatedClass(FieldValue.class)
                    .addAnnotatedClass(Group.class)

                    .addAnnotatedClass(Dossier.class)

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
