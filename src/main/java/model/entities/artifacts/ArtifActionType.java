package model.entities.artifacts;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Andrey on 15.03.2015.
 */
@Entity
@Table(name = "artif_action_types")
public class ArtifActionType {
    private Integer id;
    private String name;
    List<Action> actions;


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

    @OneToMany(mappedBy="artifActionType", fetch = FetchType.LAZY)
    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
