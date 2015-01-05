package tmp;

import org.javalite.activejdbc.Base;
import tmp.tables.Employee;

/**
 * Created by Andrey on 05.01.2015.
 */
public class DBDataHandling {
    public static void main(String[] args) {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1/mydb", "andrfas", "59722795");
        new DBDataHandling().addEmployee("Vasya");
    }

    public void addEmployee(String name) {
        Employee employee = new Employee();
        employee.set("name", name);
        employee.saveIt();
    }
}
