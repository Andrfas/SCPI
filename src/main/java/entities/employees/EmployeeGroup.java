package entities.employees;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Andrey on 22.02.2015.
 */
@Entity
@Table(name = "employee_group")
public class EmployeeGroup implements Serializable {
    private Integer id;
    private String name;
    private List<Employee> employees;
    private Set<GroupActions> actions =  new HashSet<GroupActions>();;

    public EmployeeGroup() {
    }

    public EmployeeGroup(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @ManyToMany(mappedBy = "groups",
            fetch = FetchType.LAZY)
    public Set<GroupActions> getActions() {
        return actions;
    }

    public void setActions(Set<GroupActions> actions) {
        this.actions = actions;
    }
}
