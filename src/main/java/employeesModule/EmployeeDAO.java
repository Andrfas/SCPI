package employeesModule;

import entities.employees.Employee;
import entities.employees.LoginData;
import hibernateConfig.HibernateUtil;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by Andrey on 28.02.2015.
 */
public class EmployeeDAO {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    public Employee getEmployee(int id) {

        Employee employee = null;
        Session session = factory.openSession();
        Transaction ta = null;

        try {
            ta = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);
            Criterion idCr = Restrictions.like("id", id);
            cr.add(idCr);
            employee = (Employee) cr.uniqueResult();

//            ta.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {

//            session.close();
        }

        return employee;
    }


    public Employee getEmployeeByLoginAndPass(String login, String password) {

        Employee employee = null;
        LoginData employeeLD = null;

        Session session = factory.openSession();
        Transaction ta = null;
        try {
            ta = session.beginTransaction();
            Criteria cr = session.createCriteria(LoginData.class);
            Criterion loginCr = Restrictions.like("login", login);
            Criterion passwordCr = Restrictions.like("password", password);
            cr.add(Restrictions.and(loginCr, passwordCr));
            employeeLD = (LoginData) cr.uniqueResult();

//            ta.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {

//            session.close();
        }
        if (employeeLD == null) {
            employee = null;
        } else {
            employee = employeeLD.getEmployee();
        }

        return employee;
    }
}
