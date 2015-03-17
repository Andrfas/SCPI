package entities.artifacts;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Andrey on 15.03.2015.
 */
@Entity
@Table(name = "groups")
public class Group {
    Integer id;
    String name;
    List<ArtifactType> artifType;

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
    public List<ArtifactType> getArtifType() {
        return artifType;
    }

    public void setArtifType(List<ArtifactType> artifType) {
        this.artifType = artifType;
    }
}
