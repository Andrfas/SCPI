package entities.employees;

import javax.persistence.*;
import java.io.Serializable;
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
    private Set<Employee> employees;
    private List<GroupActions> actions;

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
    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @ManyToMany(mappedBy = "groups",
            targetEntity = GroupActions.class,
            fetch = FetchType.LAZY)
    public List<GroupActions> getActions() {
        return actions;
    }

    public void setActions(List<GroupActions> actions) {
        this.actions = actions;
    }
}
