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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "files")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Files.findAll", query = "SELECT f FROM Files f"),
    @NamedQuery(name = "Files.findByIdresources", query = "SELECT f FROM Files f WHERE f.idresources = :idresources"),
    @NamedQuery(name = "Files.findByPath", query = "SELECT f FROM Files f WHERE f.path = :path"),
    @NamedQuery(name = "Files.findByDisplayname", query = "SELECT f FROM Files f WHERE f.displayname = :displayname"),
    @NamedQuery(name = "Files.findByDescription", query = "SELECT f FROM Files f WHERE f.description = :description")})
public class Files implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idresources")
    private Integer idresources;
    @Size(max = 9999)
    @Column(name = "path")
    private String path;
    @Size(max = 45)
    @Column(name = "displayname")
    private String displayname;
    @Size(max = 9999)
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "filesCollection")
    private Collection<Experiments> experimentsCollection;
    @JoinColumn(name = "filetype", referencedColumnName = "filetypeid")
    @ManyToOne
    private Filetype filetype;

    public Files() {
    }

    public Files(Integer idresources) {
        this.idresources = idresources;
    }

    public Integer getIdresources() {
        return idresources;
    }

    public void setIdresources(Integer idresources) {
        this.idresources = idresources;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Experiments> getExperimentsCollection() {
        return experimentsCollection;
    }

    public void setExperimentsCollection(Collection<Experiments> experimentsCollection) {
        this.experimentsCollection = experimentsCollection;
    }

    public Filetype getFiletype() {
        return filetype;
    }

    public void setFiletype(Filetype filetype) {
        this.filetype = filetype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresources != null ? idresources.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Files)) {
            return false;
        }
        Files other = (Files) object;
        if ((this.idresources == null && other.idresources != null) || (this.idresources != null && !this.idresources.equals(other.idresources))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitybeans.Files[ idresources=" + idresources + " ]";
    }
    
}
