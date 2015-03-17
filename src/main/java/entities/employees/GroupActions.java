package entities.employees;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Andrey on 03.03.2015.
 */
@Entity
@Table(name = "group_actions")
public class GroupActions implements Serializable {

    private Integer id;
    private String name;
    private String className;
    private Set<EmployeeGroup> groups =  new HashSet<EmployeeGroup>();;

    public GroupActions() {
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
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

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinTable(name = "empl_groups_actions",
            joinColumns = @JoinColumn(name = "action_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    public Set<EmployeeGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<EmployeeGroup> groups) {
        this.groups = groups;
    }
}
