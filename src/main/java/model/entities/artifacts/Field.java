package model.entities.artifacts;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Andrey on 15.03.2015.
 */
@Entity
@Table(name = "fields")
public class Field {
    Integer id;
    String name;
    boolean required;
    ArtifactType artifType;
    List<FieldValue> fieldValues;

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

    @Column(name="is_required", nullable=false)
    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="artifact_type_id", nullable=false)
    public ArtifactType getArtifType() {
        return artifType;
    }

    public void setArtifType(ArtifactType artifType) {
        this.artifType = artifType;
    }

    @OneToMany(mappedBy="field", fetch=FetchType.LAZY)
    public List<FieldValue> getFieldValues() {
        return fieldValues;
    }

    public void setFieldValues(List<FieldValue> fieldValues) {
        this.fieldValues = fieldValues;
    }
}
