package model.entities.artifacts;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Andrey on 15.03.2015.
 */
@Entity
@Table(name = "artifact_types")
public class ArtifactType {
    Integer id;
    String name;
    List<Artifact> artifacts;
    Group group;
    List<Field> fields;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="name", nullable=false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_id", nullable=false)
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
