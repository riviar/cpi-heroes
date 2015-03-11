/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitybeans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tools")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tools.findAll", query = "SELECT t FROM Tools t"),
    @NamedQuery(name = "Tools.findByToolid", query = "SELECT t FROM Tools t WHERE t.toolid = :toolid"),
    @NamedQuery(name = "Tools.findByDescription", query = "SELECT t FROM Tools t WHERE t.description = :description"),
    @NamedQuery(name = "Tools.findByPath", query = "SELECT t FROM Tools t WHERE t.path = :path")})
public class Tools implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "toolid")
    private Integer toolid;
    @Size(max = 9999)
    @Column(name = "description")
    private String description;
    @Size(max = 9999)
    @Column(name = "path")
    private String path;
    @OneToMany(mappedBy = "toolid")
    private Collection<Jobhistory> jobhistoryCollection;

    public Tools() {
    }

    public Tools(Integer toolid) {
        this.toolid = toolid;
    }

    public Integer getToolid() {
        return toolid;
    }

    public void setToolid(Integer toolid) {
        this.toolid = toolid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
        hash += (toolid != null ? toolid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tools)) {
            return false;
        }
        Tools other = (Tools) object;
        if ((this.toolid == null && other.toolid != null) || (this.toolid != null && !this.toolid.equals(other.toolid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitybeans.Tools[ toolid=" + toolid + " ]";
    }
    
}
