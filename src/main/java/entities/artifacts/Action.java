package entities.artifacts;

import entities.dossiers.Dossier;
import entities.employees.Employee;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Andrey on 16.03.2015.
 */
@Entity
@Table(name = "actions")
public class Action {
    private Integer id;
    private ArtifActionType artifActionType;
    private Artifact artifact;
    private Dossier dossier;
    private Employee employee;
    private Date date;


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "action_type_id", nullable = false)
    public ArtifActionType getArtifActionType() {
        return artifActionType;
    }

    public void setArtifActionType(ArtifActionType artifActionType) {
        this.artifActionType = artifActionType;
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
    @JoinColumn(name = "dossier_id", nullable = false)
    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id", nullable = false)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
