package model.entities.artifacts;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Andrey on 15.03.2015.
 */
@Entity
@Table(name = "artifacts")
public class Artifact {
    Integer id;
    ArtifactType artifactType;
    List<FieldValue> fieldValues;
    List<Action> actions;

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
    @JoinColumn(name="artifact_type_id", nullable=false)
    public ArtifactType getArtifactType() {
        return artifactType;
    }

    public void setArtifactType(ArtifactType artifactType) {
        this.artifactType = artifactType;
    }

    @OneToMany(mappedBy="artifact", fetch=FetchType.LAZY)
    public List<FieldValue> getFieldValues() {
        return fieldValues;
    }

    public void setFieldValues(List<FieldValue> fieldValues) {
        this.fieldValues = fieldValues;
    }

    @OneToMany(mappedBy="artifact", fetch = FetchType.LAZY)
    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
