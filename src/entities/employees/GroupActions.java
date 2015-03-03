package entities.employees;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Andrey on 03.03.2015.
 */
@Entity
@Table(name = "group_actions")
public class GroupActions {

    private Integer id;
    private String name;
    private String className;
    private List<EmployeeGroup> groups;

    public GroupActions() {
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

    @Column(name = "class_name", nullable = false)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @ManyToMany(targetEntity = EmployeeGroup.class)
    @JoinTable(name = "empl_groups_actions",
            joinColumns = @JoinColumn(name = "action_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    public List<EmployeeGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<EmployeeGroup> groups) {
        this.groups = groups;
    }
}
