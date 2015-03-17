package entities.dossiers;

import entities.artifacts.Action;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Andrey on 16.03.2015.
 */
@Entity
@Table(name = "dossiers")
public class Dossier {
    private Integer id;
    private List<Action> actions;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany(mappedBy="dossier", fetch = FetchType.LAZY)
    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
