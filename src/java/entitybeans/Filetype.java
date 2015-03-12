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
@Table(name = "filetype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filetype.findAll", query = "SELECT f FROM Filetype f"),
    @NamedQuery(name = "Filetype.findByFiletypeid", query = "SELECT f FROM Filetype f WHERE f.filetypeid = :filetypeid"),
    @NamedQuery(name = "Filetype.findByDescription", query = "SELECT f FROM Filetype f WHERE f.description = :description")})
public class Filetype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "filetypeid")
    private Integer filetypeid;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "filetype")
    private Collection<Files> filesCollection;

    public Filetype() {
    }

    public Filetype(Integer filetypeid) {
        this.filetypeid = filetypeid;
    }

    public Integer getFiletypeid() {
        return filetypeid;
    }

    public void setFiletypeid(Integer filetypeid) {
        this.filetypeid = filetypeid;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filetypeid != null ? filetypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filetype)) {
            return false;
        }
        Filetype other = (Filetype) object;
        if ((this.filetypeid == null && other.filetypeid != null) || (this.filetypeid != null && !this.filetypeid.equals(other.filetypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitybeans.Filetype[ filetypeid=" + filetypeid + " ]";
    }
    
}
