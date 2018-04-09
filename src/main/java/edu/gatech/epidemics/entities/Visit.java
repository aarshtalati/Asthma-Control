package edu.gatech.epidemics.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "visit")
public class Visit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer patientId;
    @NotNull
    private Date visitDate;
    @OneToMany(mappedBy = "visitId", cascade = CascadeType.ALL)
    private Set<Response> reponses;
    
    public Visit() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Set<Response> getReponses() {
        return reponses;
    }

    public void setReponses(Set<Response> reponses) {
        this.reponses = reponses;
    }
    
    @Override
    public String toString() {
        return "Visit{" + "id=" + id + ", patientId=" + patientId + ", visitDate=" + visitDate + ", reponses=" + reponses + '}';
    }
}