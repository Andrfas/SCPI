package employeesModule;

import entities.employees.Employee;
import entities.employees.LoginData;
import hibernateConfig.HibernateUtil;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Andrey on 28.02.2015.
 */
public class EmployeeDAO {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    /**
     * Returns an employee by specified id.
     * @param id of employee
     * @return Employee
     */
    public Employee getEmployee(String id) {
        Session s = factory.getCurrentSession();
        s.getTransaction().begin();
        return (Employee) s.get(Employee.class, new Integer(id));
    }

    /**
     * Looking for employees by parameters, that are not equal null. At least one parameter must be not null.
     * @param id
     * @param firstName
     * @param lastName
     * @return list of Employee
     */
    public List<Employee> getEmployees(String id, String firstName, String lastName) {
        if (id==null && firstName==null && lastName==null) throw new IllegalArgumentException();
        List<Employee> employees = null;
        Session session = factory.getCurrentSession();
        Transaction ta = null;

        try {
            ta = session.beginTransaction();
            Criteria cr = session.createCriteria(Employee.class);
            Criterion criterion = null;
            if (id != null) {
                criterion = Restrictions.and(Restrictions.like("id", id), criterion);
            }
            if (firstName != null) {
                if (criterion == null) {
                    criterion = Restrictions.like("firstName", firstName);
                } else {
                    criterion = Restrictions.and(Restrictions.like("firstName", firstName), criterion);
                }
            }
            if (lastName != null) {
                if (criterion == null) {
                    criterion = Restrictions.like("lastName", lastName);
                } else {
                    criterion = Restrictions.and(Restrictions.like("lastName", lastName), criterion);
                }
            }
            cr.add(criterion);
            employees = cr.list();

//            ta.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {

//            session.close();
        }

        return employees;
    }


    /**
     * Returns an employee by specified login and password.
     * @param login
     * @param password
     * @return
     */
    public Employee getEmployeeByLoginAndPass(String login, String password) {

        Employee employee = null;
        LoginData employeeLD = null;

        Session session = factory.getCurrentSession();
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
