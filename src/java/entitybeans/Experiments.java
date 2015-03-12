/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitybeans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "experiments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experiments.findAll", query = "SELECT e FROM Experiments e"),
    @NamedQuery(name = "Experiments.findByIdexperiments", query = "SELECT e FROM Experiments e WHERE e.idexperiments = :idexperiments"),
    @NamedQuery(name = "Experiments.findByExperimentname", query = "SELECT e FROM Experiments e WHERE e.experimentname = :experimentname"),
    @NamedQuery(name = "Experiments.findByDescription", query = "SELECT e FROM Experiments e WHERE e.description = :description")})
public class Experiments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idexperiments")
    private Integer idexperiments;
    @Size(max = 45)
    @Column(name = "experimentname")
    private String experimentname;
    @Size(max = 9999)
    @Column(name = "description")
    private String description;
    @JoinTable(name = "experiments_has_files", joinColumns = {
        @JoinColumn(name = "experiments_idexperiments", referencedColumnName = "idexperiments")}, inverseJoinColumns = {
        @JoinColumn(name = "resources_idresources", referencedColumnName = "idresources")})
    @ManyToMany
    private Collection<Files> filesCollection;
    @JoinColumn(name = "projectid", referencedColumnName = "idprojects")
    @ManyToOne(optional = false)
    private Projects projectid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "experimentid")
    private Collection<Jobhistory> jobhistoryCollection;

    public Experiments() {
    }

    public Experiments(Integer idexperiments) {
        this.idexperiments = idexperiments;
    }

    public Integer getIdexperiments() {
        return idexperiments;
    }

    public void setIdexperiments(Integer idexperiments) {
        this.idexperiments = idexperiments;
    }

    public String getExperimentname() {
        return experimentname;
    }

    public void setExperimentname(String experimentname) {
        this.experimentname = experimentname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Files> getFilesCollection() {
        return filesCollection;
    }

    public void setFilesCollection(Collection<Files> filesCollection) {
        this.filesCollection = filesCollection;
    }

    public Projects getProjectid() {
        return projectid;
    }

    public void setProjectid(Projects projectid) {
        this.projectid = projectid;
    }

    @XmlTransient
    public Collection<Jobhistory> getJobhistoryCollection() {
        return jobhistoryCollection;
    }

    public void setJobhistoryCollection(Collection<Jobhistory> jobhistoryCollection) {
        this.jobhistoryCollection = jobhistoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexperiments != null ? idexperiments.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiments)) {
            return false;
        }
        Experiments other = (Experiments) object;
        if ((this.idexperiments == null && other.idexperiments != null) || (this.idexperiments != null && !this.idexperiments.equals(other.idexperiments))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitybeans.Experiments[ idexperiments=" + idexperiments + " ]";
    }
    
}
