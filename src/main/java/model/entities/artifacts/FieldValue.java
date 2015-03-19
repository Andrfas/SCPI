package model.entities.artifacts;

import javax.persistence.*;

/**
 * Created by Andrey on 15.03.2015.
 */
@Entity
@Table(name = "field_values")
public class FieldValue {
    Integer id;
    String value;
    Artifact artifact;
    Field field;


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="value", nullable=false)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artifact_id", nullable = false)
    public Artifact getArtifact() {
        return artifact;
    }

    public void setArtifact(Artifact artifact) {
        this.artifact = artifact;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id", nullable = false)
    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
