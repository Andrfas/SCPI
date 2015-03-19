package model.dao;

import model.entities.artifacts.Action;
import model.entities.employees.Employee;
import configurations.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Andrey on 17.03.2015.
 */
public class ActionsDao {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    /* !!!
    criteria.setFetchMode("communicationAddresses", FetchMoode.EAGER);
     */


    public List<Action> getActionsByEmployee(Employee empl) {
        if (empl==null) throw new NullPointerException();

        Session session = factory.getCurrentSession();
        Transaction ta = null;

        session.getTransaction().begin();

        Criteria cr = session.createCriteria(Action.class);

        Criterion criterion = Restrictions.like("employee", empl );
        List<Action> list = cr.add(criterion).list();
        return list;
    }

}
