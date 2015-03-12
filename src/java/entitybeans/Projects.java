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
@Table(name = "projects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projects.findAll", query = "SELECT p FROM Projects p"),
    @NamedQuery(name = "Projects.findByIdprojects", query = "SELECT p FROM Projects p WHERE p.idprojects = :idprojects"),
    @NamedQuery(name = "Projects.findByProjectname", query = "SELECT p FROM Projects p WHERE p.projectname = :projectname"),
    @NamedQuery(name = "Projects.findByDescription", query = "SELECT p FROM Projects p WHERE p.description = :description"),
    @NamedQuery(name = "Projects.findByVisibility", query = "SELECT p FROM Projects p WHERE p.visibility = :visibility")})
public class Projects implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprojects")
    private Integer idprojects;
    @Size(max = 45)
    @Column(name = "projectname")
    private String projectname;
    @Size(max = 9999)
    @Column(name = "description")
    private String description;
    @Size(max = 9)
    @Column(name = "visibility")
    private String visibility;
    @JoinColumn(name = "owner", referencedColumnName = "idusers")
    @ManyToOne(optional = false)
    private Users owner;
    @JoinColumn(name = "workgroupid", referencedColumnName = "idworkgroups")
    @ManyToOne
    private Workgroups workgroupid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectid")
    private Collection<Experiments> experimentsCollection;

    public Projects() {
    }

    public Projects(Integer idprojects) {
        this.idprojects = idprojects;
    }

    public Integer getIdprojects() {
        return idprojects;
    }

    public void setIdprojects(Integer idprojects) {
        this.idprojects = idprojects;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }

    public Workgroups getWorkgroupid() {
        return workgroupid;
    }

    public void setWorkgroupid(Workgroups workgroupid) {
        this.workgroupid = workgroupid;
    }

    @XmlTransient
    public Collection<Experiments> getExperimentsCollection() {
        return experimentsCollection;
    }

    public void setExperimentsCollection(Collection<Experiments> experimentsCollection) {
        this.experimentsCollection = experimentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprojects != null ? idprojects.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projects)) {
            return false;
        }
        Projects other = (Projects) object;
        if ((this.idprojects == null && other.idprojects != null) || (this.idprojects != null && !this.idprojects.equals(other.idprojects))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitybeans.Projects[ idprojects=" + idprojects + " ]";
    }
    
}
