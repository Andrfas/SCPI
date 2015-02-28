package entities.employees;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Andrey on 22.02.2015.
 */
@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    private Integer id;
    private EmployeeGroup employeeGroup;
    private String firstName;
    private String lastName;
    private LoginData loginData;

    public Employee(){}

    public Employee(String firstName, String lastName, EmployeeGroup emplGroup) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeGroup = emplGroup;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empl_group_id", nullable = false)
    public EmployeeGroup getEmployeeGroup() {
        return employeeGroup;
    }

    public void setEmployeeGroup(EmployeeGroup employeeGroup) {
        this.employeeGroup = employeeGroup;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public LoginData getLoginData() {
        return loginData;
    }

    public void setLoginData(LoginData loginData) {
        this.loginData = loginData;
    }
}
