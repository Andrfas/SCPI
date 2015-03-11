package hibernateTest;

import employeesModule.EmployeeDAO;
import entities.employees.Employee;
import entities.employees.EmployeeGroup;
import entities.employees.GroupActions;
import entities.employees.LoginData;
import hibernateConfig.HibernateUtil;
import org.hibernate.*;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by Andrey on 23.02.2015.
 */
public class ConnectionsTest {
    private static SessionFactory factory;


    public static void main(String[] args) {
        try {
            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.WARNING); //or whatever level you need
////            factory = new Configuration().configure().buildSessionFactory();
//            factory = HibernateUtil.getSessionFactory();
//
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

//        factory = HibernateUtil.getSessionFactory();
//        initTablesData();

        Session s = checkSession();
        System.out.println(s.isConnected());
//        EmployeeDAO emplDAO = new EmployeeDAO();
//        Employee employee = emplDAO.getEmployeeByLoginAndPass("andrfas", "59722795");
//        System.out.println(employee.getFirstName());
//        Employee employee = emplDAO.getEmployee("andrfas", "59722795");
//        System.out.println(employee.getFirstName());


        //        req.setAttribute("sessionId", session.getLastAccessedTime());
//        req.getRequestDispatcher("/index.html").forward(req, resp);
    }

    @Transactional
    public static Session checkSession() {
        EmployeeDAO emplDAO = new EmployeeDAO();


        Employee employee = emplDAO.getEmployee(1);
//        System.out.println(employee.getFirstName());
        EmployeeGroup emplGroup = employee.getEmployeeGroup();
        System.out.println(emplGroup.getName());
        List<GroupActions> gActions = emplGroup.getActions();
        System.out.println(gActions.get(0).getName());
        return factory.getCurrentSession();
    }

    public static void initTablesData() {
        Session session = factory.openSession();
        Transaction tx = null;
        tx = session.beginTransaction();

        EmployeeGroup emplGroup = new EmployeeGroup("Admin");
        session.save(emplGroup);
//        emplGroup.setId(1);

//        Criteria cr = session.createCriteria(EmployeeGroup.class);
//        Criterion idCr = Restrictions.like("id", 1);
//        cr.add(idCr);
//        emplGroup = (EmployeeGroup) cr.uniqueResult();

        Employee empl = new Employee("Andrey", "Mikhatsky", emplGroup);
        session.save(empl);

        LoginData logData = new LoginData("andrfas", "59722795", empl);
        session.save(logData);

        List<EmployeeGroup> gList = new ArrayList<EmployeeGroup>();
        gList.add(emplGroup);
        GroupActions gActions = new GroupActions("Поиск пользователей", "/actions/userSearch", gList);
        session.save(gActions);

        tx.commit();
        session.close();
    }

    public void createEmployee(String name) {
        Session session = factory.openSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        EmployeeGroup emplGroup = createEmplGroup("Admin");
        Employee empl = new Employee("Vitya", "Abramovich", emplGroup);
        session.save(empl);
        tx.commit();
        session.close();
    }

    public EmployeeGroup createEmplGroup(String name) {
        Session session = factory.openSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        EmployeeGroup emplGroup = new EmployeeGroup(name);
        session.save(emplGroup);
        tx.commit();
        session.close();
        return emplGroup;
    }


//    public void listEmployees() {
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            List employees = session.createQuery("FROM Employee").list();
//            for (Iterator iterator =
//                         employees.iterator(); iterator.hasNext(); ) {
//                Employee employee = (Employee) iterator.next();
//                System.out.print("First Name: " + employee.getFirstName());
//                System.out.print("  Last Name: " + employee.getLastName());
//            }
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }

    /* Method to UPDATE salary for an employee */
    public void updateEmployee(Integer EmployeeID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee =
                    (Employee) session.get(Employee.class, EmployeeID);
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteEmployee(Integer EmployeeID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee =
                    (Employee) session.get(Employee.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
